package com.unicauca.clientuserhttpclient.access;

import co.com.hyunseda.market.presentation.GUIAdmin;
import co.com.hyunseda.market.presentation.GuioSuperAdmin;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicauca.clientuserhttpclient.Main;
import com.unicauca.clientuserhttpclient.domain.entities.User;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.unicauca.clientuserhttpclient.domain.entities.Role;
import java.util.HashMap;
import java.util.Map;
//import org.json.JSONObject;
public class UserRestRepository implements IUserRepository {
   // private JwtParser jwtParser;
    
    private String apiUrl = "http://localhost:9002/products";
    private static JwtParser jwtParser;

    // Bloque estático para inicializar jwtParser
    static {
        try {
            byte[] secretKey = "your_secret_key_here".getBytes(); // Reemplaza con tu clave secreta
            jwtParser = Jwts.parser().setSigningKey(secretKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public UserRestRepository() {

    }
    

    @Override
    public List<User> findDifferentRoleVisitor(String token) {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de productos
            // origninal, String apiUrl = "http://localhost:9002/users";
            String apiUrl = "http://localhost:8080/method/get/find";
            // Crear una solicitud GET para obtener todos los productos
            HttpGet request = new HttpGet(apiUrl);
            
             // Agregar el token en el encabezado Authorization
            request.addHeader("Authorization", "Bearer " + token);
            
            
            
            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());
                System.out.println("imprmiendo json consulta ========================="+  jsonResponse   );
                // Mapear la respuesta JSON a objetos User
                User[] users = mapper.readValue(jsonResponse, User[].class);

                for (User user : users) {
                    System.out.println("id"+ user.getUserId());
                    System.out.println("Nombre usuario: "+user.getUserName());
                    list.add(user);
                }

            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(UserRestRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(UserRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public User findById(Long id,String token) {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {

            // Definir la URL de la API REST de productos
            String apiUrl = "http://localhost:8080/method/"+String.valueOf(id);
            // Crear una solicitud GET para obtener todos los productos
            HttpGet request = new HttpGet(apiUrl);
             request.setHeader("Authorization", "Bearer " + token); 
            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos User
                user = mapper.readValue(jsonResponse, User.class);

            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(UserRestRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener el usuario" + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(UserRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
/*
    @Override
    public void create(User user,String token) {
        
        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud POST
            String url = "http://localhost:8080/auth/sign-up";

            // Crear un objeto HttpPost con la URL especificada
            HttpPost httpPost = new HttpPost(url);
             // Añadir el encabezado Authorization con el token
             httpPost.setHeader("Authorization", "Bearer " + token); 
            
            
            // Crear un objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            
            // Crear un objeto Producto
            //User product = new User(6, "Ejemplo", 10.99D); // Ejemplo de un producto

            // Convertir el objeto a JSON
            String jsonRequest = objectMapper.writeValueAsString(user);

            // Configurar la entidad de la solicitud con el JSON
            StringEntity entity = new StringEntity(jsonRequest);
            httpPost.setEntity(entity);

            // Configurar las cabeceras de la solicitud
            httpPost.setHeader("Content-Type", "application/json");
            // Si es necesario, puedes configurar otras cabeceras aquí

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(httpPost);

            // Obtener el cuerpo de la respuesta
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);

            // Imprimir la respuesta
            System.out.println("Response status: " + response.getStatusLine());
            System.out.println("Response body: " + responseBody);

            // Cerrar el cliente HttpClient
            httpClient.close();

        } catch (JsonProcessingException ex) {
            Logger.getLogger(Main.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
//       @Override
//    public void create(User user, String token) {
//        try {
//            // Crear un objeto CloseableHttpClient
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//
//            // Especificar la URL a la que se enviará la solicitud POST
//            String url = "http://localhost:8080/auth/sign-up";
//
//            // Crear un objeto HttpPost con la URL especificada
//            HttpPost httpPost = new HttpPost(url);
//            
//            // Añadir el encabezado Authorization con el token
//            httpPost.setHeader("Authorization", "Bearer " + token); 
//            
//            // Crear un objeto ObjectMapper de Jackson
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            // Convertir el objeto a JSON
//            String jsonRequest = objectMapper.writeValueAsString(user);
//
//            // Configurar la entidad de la solicitud con el JSON
//            StringEntity entity = new StringEntity(jsonRequest);
//            
//            System.out.println("json imprimendo JSON====================: " + jsonRequest);
//                httpPost.setEntity(entity);
//
//            // Configurar las cabeceras de la solicitud
//            httpPost.setHeader("Content-Type", "application/json");
//
//            // Ejecutar la solicitud y obtener la respuesta
//            HttpResponse response = httpClient.execute(httpPost);
//
//            // Obtener el cuerpo de la respuesta
//            HttpEntity responseEntity = response.getEntity();
//            String responseBody = EntityUtils.toString(responseEntity);
//            
//            // Imprimir la respuesta
//            System.out.println("Response status: " + response.getStatusLine());
//            System.out.println("Response body: " + responseBody);
//
//            // Cerrar el cliente HttpClient
//            httpClient.close();
//
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    ///este es el metodo bueno ojo===============================
    @Override
    public void create(User user, String token) {
    try {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "http://localhost:8080/auth/sign-up";
        HttpPost httpPost = new HttpPost(url);
        
        httpPost.setHeader("Authorization", "Bearer " + token); 
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Crear el objeto roleRequest
        Map<String, List<String>> roleRequest = new HashMap<>();
        List<String> roleListName = new ArrayList<>();
        for (Role role : user.getUserRoles()) {
            roleListName.add(role.getRoleName());
        }
        roleRequest.put("roleListName", roleListName);
        System.out.println("imprimiendo en el usario ==========================="+ user.getUserRolesString());
        
        // Configurar el objeto User con el roleRequest
        Map<String, Object> userMap = objectMapper.convertValue(user, Map.class);
        userMap.put("roleRequest", roleRequest);
        
        // Convertir el objeto a JSON
        String jsonRequest = objectMapper.writeValueAsString(userMap);
        
        
         System.out.println("imprimiendo en el jsonRQUEST ==========================="+ jsonRequest);
        StringEntity entity = new StringEntity(jsonRequest);
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json");

        HttpResponse response = httpClient.execute(httpPost);

        HttpEntity responseEntity = response.getEntity();
        String responseBody = EntityUtils.toString(responseEntity);
        
        System.out.println("Response status: " + response.getStatusLine());
        System.out.println("Response body: " + responseBody);

        httpClient.close();

    } catch (IOException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    
   
    
    
    
    
    
    
    
  

    
    //==========================================================================
    
    
    
//     @Override
//    public void create(User user, String token) {
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            String url = "http://localhost:8080/auth/sign-up";
//            HttpPost httpPost = new HttpPost(url);
//            httpPost.setHeader("Authorization", "Bearer " + token);
//            httpPost.setHeader("Content-Type", "application/json");
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            String jsonRequest = objectMapper.writeValueAsString(user);
//            System.out.println("Request JSON: " + jsonRequest); // Añadir esta línea para depurar
//            httpPost.setEntity(new StringEntity(jsonRequest));
//
//            HttpResponse response = httpClient.execute(httpPost);
//            String responseBody = EntityUtils.toString(response.getEntity());
//
//            System.out.println("Response status: " + response.getStatusLine());
//            System.out.println("Response body: " + responseBody);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//    
    
    
    @Override
    public void edit(Long id, User userUpdated,String token) {
        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud PUT
            String url = "http://localhost:8080/method/put/"+String.valueOf(id); // URL del producto a actualizar
            // Crear un objeto HttpPut con la URL especificada
            HttpPut httpPut = new HttpPut(url);
            
              httpPut.setHeader("Authorization", "Bearer " + token); 
            // Crear un objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Crear un objeto Producto con los datos actualizados
            User user = new User();
            user.setUserName(userUpdated.getUserName());
            user.setUserEmail(userUpdated.getUserEmail());
            user.setUserPassword(userUpdated.getUserPassword());
            user.setUserRoles(userUpdated.getUserRoles());

            // Convertir el objeto a JSON
            String requestBody = objectMapper.writeValueAsString(user);

            // Configurar el cuerpo de la solicitud con el JSON
            StringEntity entity = new StringEntity(requestBody);
            httpPut.setEntity(entity);

            // Configurar las cabeceras de la solicitud si es necesario
            httpPut.setHeader("Content-Type", "application/json");

            // Ejecutar la solicitud PUT y obtener la respuesta
            HttpResponse response = httpClient.execute(httpPut);

            // Obtener el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();

            // Imprimir el código de estado de la respuesta
            System.out.println("Status code: " + statusCode);

            // Si se desea, también se puede obtener y mostrar el cuerpo de la respuesta
             String responseBody = EntityUtils.toString(response.getEntity());
             System.out.println("Response body: " + responseBody);
            // Cerrar el cliente HttpClient
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long id,String token) {
        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud DELETE
            String url = "http://localhost:8080/method/delete/"+String.valueOf(id); // URL del producto a eliminar

            // Crear un objeto HttpDelete con la URL especificada
            HttpDelete httpDelete = new HttpDelete(url);
                httpDelete.setHeader("Authorization", "Bearer " + token); 
            // Ejecutar la solicitud DELETE y obtener la respuesta
            HttpResponse response = httpClient.execute(httpDelete);

            // Obtener el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();

            // Imprimir el código de estado de la respuesta
            System.out.println("Status code: " + statusCode);

            // Si se desea, también se puede obtener y mostrar el cuerpo de la respuesta
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("Response body: " + responseBody);

            // Cerrar el cliente HttpClient
            httpClient.close();

        } catch (IOException ex) {
            Logger.getLogger(Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void login(User user) {
         try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud POST
            String url = "http://localhost:8080/auth/log-in";

            // Crear un objeto HttpPost con la URL especificada
            HttpPost httpPost = new HttpPost(url);

            // Crear un objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Crear un objeto Producto
            //User product = new User(6, "Ejemplo", 10.99D); // Ejemplo de un producto

            // Convertir el objeto a JSON
            String jsonRequest = objectMapper.writeValueAsString(user);

            // Configurar la entidad de la solicitud con el JSON
            StringEntity entity = new StringEntity(jsonRequest);
            httpPost.setEntity(entity);

            // Configurar las cabeceras de la solicitud
            httpPost.setHeader("Content-Type", "application/json");
            // Si es necesario, puedes configurar otras cabeceras aquí

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(httpPost);

            // Obtener el cuerpo de la respuesta
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);

            // Imprimir la respuesta
            System.out.println("Response status: " + response.getStatusLine());
            System.out.println("Response body: " + responseBody);
           
           if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
              String token= extractToken(responseBody);
               System.out.println("token: "+token);
                      
               if (isAdmin3(token)) {
                   JOptionPane.showMessageDialog(null, "ingresado con exito administrador");
                    GUIAdmin instance = new GUIAdmin();
                    instance.setVisible(true);
                } else if(isSuperAdmin(token)){
                     JOptionPane.showMessageDialog(null, "ingresado con exito superadministrador");
                     GuioSuperAdmin insta = new GuioSuperAdmin(token);
                     insta.setVisible(true);
                     
                }else{
                  JOptionPane.showMessageDialog(null, "el usario no tiene permiso de administrador");

                    
                } 
                   
            } else {
                JOptionPane.showMessageDialog(null, "ERROR SUS CREDENCIALES SON INCORRECTAS");
        }
            // Cerrar el cliente HttpClient
            httpClient.close();

        } catch (JsonProcessingException ex) {
            Logger.getLogger(Main.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
         

    }
    
    public static String extractToken(String responseBody) {
        // Crear un objeto JSONObject a partir del cuerpo de la respuesta
        JSONObject jsonResponse = new JSONObject(responseBody);

        // Extraer el valor asociado con la clave "jwt"
        String token = jsonResponse.getString("jwt");

        return token;
    }
    
  public boolean isAdmin(String jwt) {
        try {
            // Decodificar y analizar el token JWT para obtener las reclamaciones (claims)
            Claims claims = jwtParser.parseClaimsJws(jwt).getBody();
            
            // Obtener las autorizaciones del token JWT
            String authorities = (String) claims.get("authorities");
            System.out.println("autoricacion"+ authorities);
            // Verificar si el usuario es administrador
            return authorities != null && authorities.contains("ROLE_ADMIN");
        } catch (JwtException e) {
            // Manejar la excepción si ocurre algún error al decodificar o analizar el token JWT
            e.printStackTrace();
            return false; // o manejar el error de otra manera
        }
    }
   // Método que verifica si el usuario es administrador
    public static boolean isAdmin2(String jwt) {
        try {
            // Decodificar y analizar el token JWT para obtener las reclamaciones (claims)
            Claims claims = jwtParser.parseClaimsJws(jwt).getBody();

            // Obtener las autorizaciones del token JWT
            String authorities = claims.get("authorities", String.class);
            System.out.println("autoricacion"+ authorities);
            // Verificar si el usuario es administrador
            return authorities != null && authorities.contains("ROLE_ADMIN");
        } catch (JwtException e) {
            // Manejar la excepción si ocurre algún error al decodificar o analizar el token JWT
            e.printStackTrace();
            return false; // o manejar el error de otra manera
        }
    }
    /* validando si su rol es administrador**/
     public static boolean isAdmin3(String token) {
        // Decodificar el token
        DecodedJWT jwt = JWT.decode(token);

        // Extraer el payload
        String authorities = jwt.getClaim("authorities").asString();
         System.out.println("imprminendo rol extrac:"+ authorities);
        // Verificar si contiene "ROLE_ADMIN"
        if (authorities != null && authorities.contains("ROLE_ADMIN")) {
            return true;
        } else {
            return false;
        }
    }
     
    /* validando si es superAdministrador  **/
     
       public static boolean isSuperAdmin(String token) {
        // Decodificar el token
        DecodedJWT jwt = JWT.decode(token);

        // Extraer el payload
        String authorities = jwt.getClaim("authorities").asString();

        // Verificar si contiene "ROLE_ADMIN"
        if (authorities != null && authorities.contains("ROLE_SUPERADMIN")) {
            return true;
        } else {
            return false;
        }
    }

}
