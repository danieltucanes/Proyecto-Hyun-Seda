/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.clientuserhttpclient.access;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicauca.clientuserhttpclient.domain.entities.Role;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Felipe Castro
 */
public class RoleRestRepository implements IRoleRepository{
//    
//    @Override
//    public List<Role> findAll(String token ){
//        HttpClient httpClient = HttpClients.createDefault();
//        ObjectMapper mapper = new ObjectMapper();
//        List<Role> list = new ArrayList<>();
//        try {
//
//            // Definir la URL de la API REST de productos
//            String apiUrl = "http://localhost:8080/roles";
//            // Crear una solicitud GET para obtener todos los productos
//            HttpGet request = new HttpGet(apiUrl);
//
//            // Ejecutar la solicitud y obtener la respuesta
//            HttpResponse response = httpClient.execute(request);
//
//            // Verificar el código de estado de la respuesta
//            int statusCode = response.getStatusLine().getStatusCode();
//            if (statusCode == 200) {
//                // La solicitud fue exitosa, procesar la respuesta
//                String jsonResponse = EntityUtils.toString(response.getEntity());
//
//                // Mapear la respuesta JSON a objetos User
//                Role[] roles = mapper.readValue(jsonResponse, Role[].class);
//
//                for (Role rol : roles) {
//                    list.add(rol);
//                }
//
//            } else {
//                // La solicitud falló, mostrar el código de estado
//                Logger.getLogger(UserRestRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(UserRestRepository.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }


//@Override
//public List<Role> findAll(String token) {
//    HttpClient httpClient = HttpClients.createDefault();
//    ObjectMapper mapper = new ObjectMapper();
//    List<Role> list = new ArrayList<>();
//    try {
//        // Definir la URL de la API REST de roles
//        String apiUrl = "http://localhost:8080/roles/find";
//        // Crear una solicitud GET para obtener todos los roles
//        HttpGet request = new HttpGet(apiUrl);
//
//        // Obtener el token de alguna fuente (por ejemplo, variable de entorno)
//        // String token = System.getenv("API_TOKEN"); // Asumiendo que el token se almacena en una variable de entorno
//
//        // Añadir el encabezado Authorization con el token
//        request.setHeader("Authorization", "Bearer " + token);
//
//        // Ejecutar la solicitud y obtener la respuesta
//        HttpResponse response = httpClient.execute(request);
//
//        // Verificar el código de estado de la respuesta
//        int statusCode = response.getStatusLine().getStatusCode();
//        if (statusCode == 200) {
//            // La solicitud fue exitosa, procesar la respuesta
//            String jsonResponse = EntityUtils.toString(response.getEntity());
//
//            // Deserializar el JSON en una lista de arrays de objetos
//            List<List<Object>> roleLists = mapper.readValue(jsonResponse, new TypeReference<List<List<Object>>>() {});
//
//            // Iterar sobre la lista de listas y crear instancias de Role
//            for (List<Object> roleList : roleLists) {
//                Long roleId = ((Number) roleList.get(0)).longValue(); // Obtener el ID del rol del array
//                String roleName = (String) roleList.get(1); // Obtener el nombre del rol del array
//
//                // Crear una nueva instancia de Role y agregarla a la lista
//                Role role = new Role();
//                role.setRoleId(roleId);
//                role.setRoleName(roleName);
//                list.add(role);
//            }
//        } else {
//            // La solicitud falló, mostrar el código de estado
//            Logger.getLogger(UserRestRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener roles. Código de estado: " + statusCode);
//        }
//    } catch (IOException ex) {
//        Logger.getLogger(UserRestRepository.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    return list;
//}
 private final ObjectMapper mapper = new ObjectMapper();
     @Override
    public List<Role> findAll(String token) {
        HttpClient httpClient = HttpClients.createDefault();
        List<Role> roles = new ArrayList<>();

        try {
            String apiUrl = "http://localhost:8080/roles/find";
            HttpGet request = new HttpGet(apiUrl);
            request.addHeader("Authorization", "Bearer " + token);

            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                String jsonResponse = EntityUtils.toString(response.getEntity());
                Object[][] dataArray = mapper.readValue(jsonResponse, Object[][].class);

                for (Object[] data : dataArray) {
                    Long id = Long.parseLong(data[0].toString());
                    String roleName = (String) data[1];
                    Role role = new Role();
                    role.setRoleId(id);
                    role.setRoleName(roleName);
                    roles.add(role);
                }
            } else {
                Logger.getLogger(UserRestRepository.class.getName())
                      .log(Level.SEVERE, null, "Error al obtener roles. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(UserRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return roles;
    }



}
