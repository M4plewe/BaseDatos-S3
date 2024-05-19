import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserManager {
    private HashMap<String, String> users;
    private HashMap<String, List<Evento>> userEvents;

    public UserManager() {
        users = new HashMap<>();
        userEvents = new HashMap<>();
    }

    public boolean addUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // El usuario ya existe
        }

        users.put(username, password);
        userEvents.put(username, new ArrayList<>()); // Inicializar la lista de eventos del usuario
        return true; // El usuario fue agregado exitosamente
    }

    public boolean checkUser(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public void addEventToUser(String username, Evento evento) {
        if (userEvents.containsKey(username)) {
            userEvents.get(username).add(evento);
        }
    }

    public List<Evento> getUserEvents(String username) {
        return userEvents.get(username);
    }
}