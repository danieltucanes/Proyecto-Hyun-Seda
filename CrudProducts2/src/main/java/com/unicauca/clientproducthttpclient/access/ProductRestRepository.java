package com.unicauca.clientproducthttpclient.access;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicauca.clientproducthttpclient.domain.entities.Category;
import com.unicauca.clientproducthttpclient.domain.entities.Product;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ProductRestRepository implements IProductRepository {

    private String apiUrl = "http://localhost:8090/products";

    public ProductRestRepository() {

    }

    @Override
    public List<Product> findAll() {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<Product> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de productos
            String apiUrl = "http://localhost:8090/v1/products";
            // Crear una solicitud GET para obtener todos los productos
            HttpGet request = new HttpGet(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos Product
                Product[] products = mapper.readValue(jsonResponse, Product[].class);

                for (Product product : products) {
                    list.add(product);
                }

            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

@Override
public Product findById(long id) {
    HttpClient httpClient = HttpClients.createDefault();
    ObjectMapper mapper = new ObjectMapper();
    Product product = null; // Declarar product fuera del bloque try

    try {
        String apiUrl = "http://localhost:8090/v1/products/id/" + id;
        HttpGet request = new HttpGet(apiUrl);
        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        
        if (statusCode == 200) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            product = mapper.readValue(jsonResponse, Product.class);
            JOptionPane.showMessageDialog(null, "Producto encontrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            JOptionPane.showMessageDialog(null, "Error al obtener productos. Código de estado: " + statusCode, "Error", JOptionPane.ERROR_MESSAGE);
            // Podrías mostrar un mensaje más específico dependiendo del código de estado
        }
    } catch (IOException ex) {
        Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al realizar la búsqueda del producto", "Error", JOptionPane.ERROR_MESSAGE);
        // Aquí puedes lanzar una excepción personalizada o devolver un valor predeterminado
    }
    
    return product; // Devolver product al final del método
}

    //encontrar producto por nombre 

    
    
    @Override
    public void create(Product product) {
    try {
        
        System.out.println("id"+product.getProductId());
        // Crear un objeto CloseableHttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // Especificar la URL a la que se enviará la solicitud POST
        String url = "http://localhost:8090/v1/products";

        // Crear un objeto HttpPost con la URL especificada
        HttpPost httpPost = new HttpPost(url);

        // Crear un objeto ObjectMapper de Jackson
        ObjectMapper objectMapper = new ObjectMapper();

        // Convertir el objeto a JSON
        String jsonRequest = objectMapper.writeValueAsString(product);
        System.out.println("JSON Request: " + jsonRequest);

        // Configurar la entidad de la solicitud con el JSON
        StringEntity entity = new StringEntity(jsonRequest);
        httpPost.setEntity(entity);

        // Configurar las cabeceras de la solicitud
        httpPost.setHeader("Content-Type", "application/json");

        // Ejecutar la solicitud y obtener la respuesta
        HttpResponse response = httpClient.execute(httpPost);

        // Verificar el código de estado de la respuesta
        int statusCode = response.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(response.getEntity());

        // Cerrar el cliente HttpClient
        httpClient.close();

        // Manejar la respuesta según el código de estado
        if (statusCode >= 200 && statusCode < 300) {
            // Si la solicitud fue exitosa
            System.out.println("Response status: " + response.getStatusLine());
            System.out.println("Response body: " + responseBody);
            JOptionPane.showMessageDialog(null, "Producto creado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si la solicitud falló
            System.err.println("Error al crear el producto. Código de estado: " + statusCode);
            System.err.println("Response body: " + responseBody);
            JOptionPane.showMessageDialog(null, "Error al crear el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (JsonProcessingException ex) {
        Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al procesar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (UnsupportedEncodingException ex) {
        Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error de codificación no soportada", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
        Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error de E/S", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    @Override
    public void edit(long id, Product productUpdated) {
        System.out.println("ENTRO AL METODO EDITAR");

        
        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();
            System.out.println("ENTRO AL METODO EDITAR------------------------------");
            // Especificar la URL a la que se enviará la solicitud PUT
            String url = "http://localhost:8090/v1/products/" + id; // URL del producto a actualizar

            // Crear un objeto HttpPut con la URL especificada
            HttpPut httpPut = new HttpPut(url);

            // Crear un objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Crear un objeto Producto con los datos actualizados
            Product product2 = new Product();
            product2.setProductId(id);
            product2.setName(productUpdated.getName());
            product2.setDescription(productUpdated.getDescription());
            product2.setPrice(productUpdated.getPrice());
            product2.setImages(productUpdated.getImages());
            System.out.println("imagen"+product2.getImages());
            product2.setCharacteristics(productUpdated.getCharacteristics());
            product2.setSlug(productUpdated.getSlug());
            product2.setStock(productUpdated.getStock());
            product2.setKeywords(productUpdated.getKeywords());
            product2.setCategories(productUpdated.getCategories());
            
            // 

            // Convertir el objeto a JSON
            String requestBody = objectMapper.writeValueAsString(product2);

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
            JOptionPane.showMessageDialog(null, "Categoría Actualizada exitosamente--verificando", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (JsonProcessingException | UnsupportedEncodingException ex) {
            Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Actualizar la categoría", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void delete(long id) {

        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud DELETE
            String url = "http://localhost:8090/v1/products/" + id; // URL del producto a eliminar

            // Crear un objeto HttpDelete con la URL especificada
            HttpDelete httpDelete = new HttpDelete(url);

            // Ejecutar la solicitud DELETE y obtener la respuesta
            HttpResponse response = httpClient.execute(httpDelete);

            // Obtener el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();

            // Imprimir el código de estado de la respuesta
            System.out.println("Status code: " + statusCode);

            // Si se desea, también se puede obtener y mostrar el cuerpo de la respuesta
            // String responseBody = EntityUtils.toString(response.getEntity());
            if (response.getEntity() != null) {
                // Si se desea, también se puede obtener y mostrar el cuerpo de la respuesta
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Response body: " + responseBody);
            } else {
                System.out.println("No hay cuerpo de respuesta.");
            }

            //      System.out.println("Response body: " + responseBody);
            // Cerrar el cliente HttpClient
            httpClient.close();
            JOptionPane.showMessageDialog(null, "Producto Eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            Logger.getLogger(CategoryRestRepository.class
                    .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Eliminar  la categoría", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Product findProductByName(String name) {
        HttpClient httpClient = HttpClients.createDefault();
    ObjectMapper mapper = new ObjectMapper();
    Product product = null; // Declarar product fuera del bloque try

    try {           
        String apiUrl = "http://localhost:8090/v1/products/name/" + name;
        HttpGet request = new HttpGet(apiUrl);
        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        
        if (statusCode == 200) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            product = mapper.readValue(jsonResponse, Product.class);
            JOptionPane.showMessageDialog(null, "Producto encontrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            JOptionPane.showMessageDialog(null, "Error al obtener el  producto. Código del estado: " + statusCode, "Error", JOptionPane.ERROR_MESSAGE);
            // Podrías mostrar un mensaje más específico dependiendo del código de estado
        }
    } catch (IOException ex) {
        Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al realizar la búsqueda del producto", "Error", JOptionPane.ERROR_MESSAGE);
        // Aquí puedes lanzar una excepción personalizada o devolver un valor predeterminado
    }
    
    return product; // Devolver product al final del método

    }

    @Override
    public List<Product> findProductsByCategory(String categories) {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<Product> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de productos
            String apiUrl = "http://localhost:8090/v1/productsbycategories/"+categories;
            // Crear una solicitud GET para obtener todos los productos
            HttpGet request = new HttpGet(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos Product
                Product[] products = mapper.readValue(jsonResponse, Product[].class);

                for (Product product : products) {
                    list.add(product);
                }

            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProductRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }



}
