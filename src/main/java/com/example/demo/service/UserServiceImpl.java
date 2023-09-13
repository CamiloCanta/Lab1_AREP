package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Map<Long, User> users = new HashMap<>();
    private Long nextUserId = 1L; // Para generar IDs únicos

    @Override
    public User createUser(User user) {
        // Generar un nuevo ID único para el usuario
        Long userId = generateUserId();

        // Asignar el ID generado al usuario
        user.setId(userId);

        // Almacenar el usuario en el HashMap
        users.put(userId, user);

        return user;
    }

    @Override
    public User readUser(Long userId) {
        // Buscar el usuario por su ID en el HashMap
        return users.get(userId);
    }

    @Override
    public User updateUser(Long userId, User user) {
        // Verificar si el usuario existe
        if (users.containsKey(userId)) {
            // Actualizar el usuario en el HashMap
            users.put(userId, user);
            return user;
        }
        return null; // Devolver null si el usuario no se encuentra
    }

    @Override
    public boolean deleteUser(Long userId) {
        // Verificar si el usuario existe
        if (users.containsKey(userId)) {
            // Eliminar el usuario del HashMap
            users.remove(userId);
            return true; // Indicar que la eliminación se realizó con éxito
        }
        return false; // Indicar que el usuario no se encontró y no se pudo eliminar
    }

    // Método privado para generar un ID único
    private synchronized Long generateUserId() {
        return nextUserId++;
    }
}
