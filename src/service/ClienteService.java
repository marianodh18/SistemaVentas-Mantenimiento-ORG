package service;

import model.Cliente;
import repository.ClienteRepository;
import util.Console;

public class ClienteService {

    private final ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public void registrarCliente(String dni, String nombre, String tipo) {

        // DNI obligatorio y de 8 dígitos numéricos
        if (dni == null || dni.trim().isEmpty() || !dni.matches("\\d{8}")) {
            Console.error("Cliente inválido");
            return;
        }

        Cliente cliente = new Cliente(dni, nombre, tipo);
        clienteRepo.guardar(cliente);
        Console.info("Cliente registrado: " + nombre);
    }

    public Cliente buscarCliente(String dni) {
        return clienteRepo.buscarPorDni(dni);
    }
}
