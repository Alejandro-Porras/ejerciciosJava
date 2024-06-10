package ud09.actividades._12_redes;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner entrada = new Scanner(System.in);

        IRepository<Usuario> usuarioDAO = new UsuarioRepositoryImpl();
        IRepository<Post> postDAO = new PostRepositoryImpl();
        IRepository<Comment> comentarioDAO = new CommentRepositoryImpl();

        try (Connection con = DbConnect.getInstance().getConnection()) {
            while (true) {
                menuPrincipal();
                int opcion = entrada.nextInt();
                entrada.nextLine();

                switch (opcion) {
                    case 1:
                        gestionarUsuarios(entrada, usuarioDAO);
                        break;
                    case 2:
                        gestionarPosts(entrada, postDAO, usuarioDAO);
                        break;
                    case 3:
                        gestionarComentarios(entrada, comentarioDAO, usuarioDAO, postDAO);
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        entrada.close();
                        System.exit(0);
                    default:
                        System.out.println("Opción inválida. Intenta de nuevo.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos: " + e.getMessage());
        }
    }

    private static void gestionarUsuarios(Scanner entrada, IRepository<Usuario> usuarioDAO) {
        while (true) {
            menuUsuarios();
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del usuario: ");
                    String nombre = entrada.nextLine();
                    System.out.print("Introduce el apellido del usuario: ");
                    String apellido = entrada.nextLine();
                    Usuario nuevoUsuario = new Usuario(0, nombre, apellido);
                    try {
                        usuarioDAO.crear(nuevoUsuario);
                        System.out.println("Usuario creado con ID: " + nuevoUsuario.getId());
                    } catch (SQLException e) {
                        System.out.println("Error al crear usuario: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Introduce el ID del usuario a consultar: ");
                    int idUsuario = entrada.nextInt();
                    entrada.nextLine();
                    try {
                        Usuario usuario = usuarioDAO.obtener(idUsuario);
                        if (usuario != null) {
                            System.out.println("Usuario encontrado:");
                            System.out.printf(" %-3d %-15s %-15s%n",
                                    usuario.getId(),
                                    usuario.getNombre(),
                                    usuario.getApellido());
                        } else {
                            System.out.println("No se encontró ningún usuario con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener usuario: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        List<Usuario> usuarios = usuarioDAO.obtenerTodos();
                        if (!usuarios.isEmpty()) {
                            System.out.println("Listado de Usuarios:");
                            for (Usuario u : usuarios) {
                                System.out.println("ID: " + u.getId() + ", Nombre: " + u.getNombre() + ", Apellido: " + u.getApellido());
                            }
                        } else {
                            System.out.println("No hay usuarios registrados.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener todos los usuarios: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Introduce el ID del usuario a actualizar: ");
                    int idActualizar = entrada.nextInt();
                    entrada.nextLine();
                    try {
                        Usuario usuarioActualizar = usuarioDAO.obtener(idActualizar);
                        if (usuarioActualizar != null) {
                            System.out.print("Introduce el nuevo nombre del usuario (deja en blanco para mantener el actual): ");
                            String nuevoNombre = entrada.nextLine();
                            if (!nuevoNombre.isEmpty()) {
                                usuarioActualizar.setNombre(nuevoNombre);
                            }

                            System.out.print("Introduce el nuevo apellido del usuario (deja en blanco para mantener el actual): ");
                            String nuevoApellido = entrada.nextLine();
                            if (!nuevoApellido.isEmpty()) {
                                usuarioActualizar.setApellido(nuevoApellido);
                            }
                            usuarioDAO.actualizar(usuarioActualizar);
                            System.out.println("Usuario actualizado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún usuario con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al actualizar usuario: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Introduce el ID del usuario a eliminar: ");
                    int idEliminar = entrada.nextInt();
                    entrada.nextLine();
                    try {
                        Usuario usuarioActualizar = usuarioDAO.obtener(idEliminar);
                        if (usuarioActualizar != null) {
                            usuarioDAO.eliminar(idEliminar);
                            System.out.println("Usuario eliminado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún usuario con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al eliminar usuario: " + e.getMessage());
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void gestionarPosts(Scanner entrada, IRepository<Post> postDAO, IRepository<Usuario> usuarioDAO) {
        while (true) {
            menuPosts();
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el texto del post: ");
                    String texto = entrada.nextLine();

                    System.out.println("Elige un usuario: ");

                    UsuarioRepositoryImpl usuarioRepository = new UsuarioRepositoryImpl();
                    List<Usuario> usuarios;
                    int usuarioId = 0;
                    try {
                        usuarios = usuarioRepository.obtenerTodos();
                        for (Usuario usuario : usuarios) {
                            System.out.println(usuario.getId() + " - " + usuario.getNombre() + " " + usuario.getApellido());
                        }
                        System.out.print("Introduce el ID del usuario que publica el post:  ");
                        usuarioId = entrada.nextInt();
                    } catch (SQLException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }

                    Post nuevoPost = new Post(0, texto, 0, LocalDate.now(), usuarioId);
                    try {
                        postDAO.crear(nuevoPost);
                        System.out.println("Post creado con ID: " + nuevoPost.getId());
                    } catch (SQLException e) {
                        System.out.println("Error al crear post: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Introduce el ID del post a consultar: ");
                    int idPost = entrada.nextInt();
                    entrada.nextLine();
                    try {
                        Post post = postDAO.obtener(idPost);
                        if (post != null) {
                            System.out.println("Post encontrado:");
                            System.out.printf(" %-3d %-15s %-20s %-4d %n",
                                    post.getId(),
                                    post.getTexto(),
                                    post.getFecha(),
                                    post.getUserId());
                        } else {
                            System.out.println("No se encontró ningún post con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener post: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        List<Post> posts = postDAO.obtenerTodos();
                        if (!posts.isEmpty()) {
                            System.out.println("Listado de Posts:");
                            for (Post p : posts) {
                                System.out.printf(" %-3d %-15s %-20s %-4d %n",
                                        p.getId(),
                                        p.getTexto(),
                                        p.getFecha(),
                                        p.getUserId());
                            }
                        } else {
                            System.out.println("No hay posts registrados.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener todos los posts: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Introduce el ID del post a actualizar: ");
                    int idActualizar = entrada.nextInt();
                    entrada.nextLine();
                    try {
                        Post postActualizar = postDAO.obtener(idActualizar);
                        if (postActualizar != null) {
                            System.out.print("Introduce el nuevo texto del post (deja en blanco para mantener el actual): ");
                            String nuevoTexto = entrada.nextLine();
                            if (!nuevoTexto.isEmpty()) {
                                postActualizar.setTexto(nuevoTexto);
                            }
                            postDAO.actualizar(postActualizar);
                            System.out.println("Post actualizado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún post con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al actualizar post: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Introduce el ID del post a eliminar: ");
                    int idEliminar = entrada.nextInt();
                    entrada.nextLine();
                    try {
                        Post postEliminar = postDAO.obtener(idEliminar);
                        if (postEliminar != null) {
                            postDAO.eliminar(idEliminar);
                            System.out.println("Post eliminado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún post con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al eliminar post: " + e.getMessage());
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void gestionarComentarios(Scanner entrada, IRepository<Comment> comentarioDAO, IRepository<Usuario> usuarioDAO, IRepository<Post> postDAO) {
        while (true) {
            menuComentarios();
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el texto del comentario: ");
                    String texto = entrada.nextLine();

                    System.out.print("Introduce el ID del usuario que realiza el comentario: ");
                    int idUsuario = entrada.nextInt();

                    System.out.print("Introduce el ID del post al que se realiza el comentario: ");
                    int idPost = entrada.nextInt();

                    Comment nuevoComentario = new Comment(0, texto, LocalDate.now(), idUsuario, idPost); 
                    try {
                        comentarioDAO.crear(nuevoComentario);
                        System.out.println("Comentario creado con ID: " + nuevoComentario.getId());
                    } catch (SQLException e) {
                        System.out.println("Error al crear comentario: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Introduce el ID del comentario a consultar: ");
                    int idComentario = entrada.nextInt();
                    entrada.nextLine();
                    try {
                        Comment comentario = comentarioDAO.obtener(idComentario);
                        if (comentario != null) {
                            System.out.println("Comentario encontrado:");
                            System.out.printf(" %-3d %-15s %-20s %-4d %-4d%n",
                                    comentario.getId(),
                                    comentario.getTexto(),
                                    comentario.getFecha(),
                                    comentario.getUserId(),
                                    comentario.getPostId());
                        } else {
                            System.out.println("No se encontró ningún comentario con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener comentario: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        List<Comment> comentarios = comentarioDAO.obtenerTodos();
                        if (!comentarios.isEmpty()) {
                            System.out.println("Listado de Comentarios:");
                            for (Comment c : comentarios) {
                                System.out.printf(" %-3d %-15s %-20s %-4d %-4d%n",
                                        c.getId(),
                                        c.getTexto(),
                                        c.getFecha(),
                                        c.getUserId(),
                                        c.getPostId());
                            }
                        } else {
                            System.out.println("No hay comentarios registrados.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al obtener todos los comentarios: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Introduce el ID del comentario a actualizar: ");
                    int idActualizar = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer del entrada
                    try {
                        Comment comentarioActualizar = comentarioDAO.obtener(idActualizar);
                        if (comentarioActualizar != null) {
                            System.out.print("Introduce el nuevo texto del comentario deja en blanco para mantener el actual): ");
                            String nuevoTexto = entrada.nextLine();
                            if (!nuevoTexto.isEmpty()) {
                                comentarioActualizar.setTexto(nuevoTexto);
                            }
                            comentarioDAO.actualizar(comentarioActualizar);
                            System.out.println("Comentario actualizado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún comentario con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al actualizar comentario: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Introduce el ID del comentario a eliminar: ");
                    int idEliminar = entrada.nextInt();
                    entrada.nextLine();
                    try {
                        Comment comentarioEliminar = comentarioDAO.obtener(idEliminar);
                        if (comentarioEliminar != null) {
                            comentarioDAO.eliminar(idEliminar);
                            System.out.println("Comentario eliminado correctamente.");
                        } else {
                            System.out.println("No se encontró ningún comentario con ese ID.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al eliminar comentario: " + e.getMessage());
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void menuPrincipal() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Gestionar Usuarios");
        System.out.println("2. Gestionar Posts");
        System.out.println("3. Gestionar Comentarios");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción:  ");
    }

    private static void menuUsuarios() {
        System.out.println("\nMenú de Usuarios:");
        System.out.println("1. Crear usuario");
        System.out.println("2. Consultar usuario por ID");
        System.out.println("3. Listar todos los usuarios");
        System.out.println("4. Actualizar usuario");
        System.out.println("5. Eliminar usuario");
        System.out.println("0. Volver al menú principal");
        System.out.print("Selecciona una opción:  ");
    }

    private static void menuPosts() {
        System.out.println("\nMenú de Posts:");
        System.out.println("1. Crear post");
        System.out.println("2. Consultar post por ID");
        System.out.println("3. Listar todos los posts");
        System.out.println("4. Actualizar post");
        System.out.println("5. Eliminar post");
        System.out.println("0. Volver al menú principal");
        System.out.print("Selecciona una opción:  ");
    }

    private static void menuComentarios() {
        System.out.println("\nMenú de Comentarios:");
        System.out.println("1. Crear comentario");
        System.out.println("2. Consultar comentario por ID");
        System.out.println("3. Listar todos los comentarios");
        System.out.println("4. Actualizar comentario");
        System.out.println("5. Eliminar comentario");
        System.out.println("0. Volver al menú principal");
        System.out.print("Selecciona una opción:  ");
    }
}

