/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author ACER
 */
public class CategoryRestRepository implements ICategoryRepository {

    private String apiUrl = "http://localhost:8090/categories";

    public CategoryRestRepository() {
    }

    @Override
    public List<Category> findAll() {

        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<Category> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de productos
            String apiUrl = "http://localhost:8090/v1/categories";
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
                Category[] categories = mapper.readValue(jsonResponse, Category[].class);

                for (Category category : categories) {
                    list.add(category);
                }

            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(CategoryRestRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(CategoryRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Product findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public void create(Category category) {
        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud POST
            String url = "http://localhost:8090/v1/categories";

            // Crear un objeto HttpPost con la URL especificada
            HttpPost httpPost = new HttpPost(url);

            // Crear un objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Convertir el objeto a JSON
            String jsonRequest = objectMapper.writeValueAsString(category);

            // Configurar la entidad de la solicitud con el JSON
            StringEntity entity = new StringEntity(jsonRequest);
            System.out.println("JSON Request: " + jsonRequest);
            httpPost.setEntity(entity);

            // Configurar las cabeceras de la solicitud
            httpPost.setHeader("Content-Type", "application/json");

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
            JOptionPane.showMessageDialog(null, "Categoría creada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(CategoryRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CategoryRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CategoryRestRepository.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al crear la categoría", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void edit(long id, Category categoryUpdated) {

        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud PUT
            String url = "http://localhost:8090/v1/categories/" + id; // URL del producto a actualizar

            // Crear un objeto HttpPut con la URL especificada
            HttpPut httpPut = new HttpPut(url);

            // Crear un objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Crear un objeto Producto con los datos actualizados
            Category category = new Category();
            category.setCategoryId(id);
            category.setName(categoryUpdated.getName());
            // En este caso, estamos suponiendo que solo se actualizará el nombre y el precio del producto

            // Convertir el objeto a JSON
            String requestBody = objectMapper.writeValueAsString(category);

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
            JOptionPane.showMessageDialog(null, "Categoría Actualizada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(CategoryRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CategoryRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CategoryRestRepository.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Actualizar la categoría", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void delete(long id) {
        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud DELETE
            String url = "http://localhost:8090/v1/categories/" + id; // URL del producto a eliminar

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
            JOptionPane.showMessageDialog(null, "Categoría Eliminada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            Logger.getLogger(CategoryRestRepository.class
                    .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Eliminar  la categoría", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
