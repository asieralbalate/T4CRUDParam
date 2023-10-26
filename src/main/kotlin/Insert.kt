package exemples

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*

fun insert(){
    val url = "jdbc:sqlite:identifier.sqlite"
    val con: Connection

    try {
        con = DriverManager.getConnection(url)
        val st = con.createStatement()
        println("Añade una nueva fila")
        println("Introduce el nombre:")
        val nombre = Scanner(System.`in`).nextLine()
        println("Introduce el usuario:")
        val user = Scanner(System.`in`).nextLine()
        println("Introduce la contraseña:")
        val pass = Scanner(System.`in`).nextLine()
        println("Introduce el teléfono:")
        val tlf = Scanner(System.`in`).nextInt()
        println("Introduce el email:")
        val email = Scanner(System.`in`).nextLine()

        st.executeUpdate(
            "INSERT OR REPLACE INTO USUARIO (Nombre, Usuari, Password, Telefono, Email) " +
                    "VALUES ('$nombre', '$user', '$pass', $tlf, '$email')"
        );
        selectAll()
        st.close()
        con.close()
    } catch (e: SQLException) {
        println("Aun no existe la tabla")
        showMenu()
    }
}