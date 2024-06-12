/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.access.order;

import co.com.hyunseda.entities.order.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author X1605
 */
public class ItemRestRepository implements IItemRepository{

    @Override
    public List<Item> findAll() {
       HttpClient httpClient = HttpClients.createDefault();
      
        ObjectMapper mapper = new ObjectMapper();
        List<Item> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de productos
            String apiUrl = "http://localhost:9090/items";
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
                Item[] items = mapper.readValue(jsonResponse, Item[].class);

                for (Item item : items) {
                    list.add(item);
                }

            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(ItemRestRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(ItemRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Item item) {
        try {
            // Crear un objeto CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Especificar la URL a la que se enviará la solicitud POST
            String url = "http://localhost:9090/items";

            // Crear un objeto HttpPost con la URL especificada
            HttpPost httpPost = new HttpPost(url);

            // Crear un objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Crear un objeto Item
            //Item product = new Item(6); // Ejemplo de un producto

            // Convertir el objeto a JSON
            String jsonRequest = objectMapper.writeValueAsString(item);

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
            Logger.getLogger(ItemRestRepository.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ItemRestRepository.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(ItemRestRepository.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(int id, Item itemUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Item> itemsByOrder(Long id) {
         HttpClient httpClient = HttpClients.createDefault();
      
        ObjectMapper mapper = new ObjectMapper();
        List<Item> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de productos
            String apiUrl = "http://localhost:9090/items/items/"+id;
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
                Item[] items = mapper.readValue(jsonResponse, Item[].class);

                for (Item item : items) {
                    list.add(item);
                }

            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(ItemRestRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(ItemRestRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

   
    
}
