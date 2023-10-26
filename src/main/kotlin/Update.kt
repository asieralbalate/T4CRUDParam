package exemples

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

fun update (){
    val url = "jdbc:sqlite:identifier.sqlite"
    val con: Connection
    try {
        con = DriverManager.getConnection(url)
        val st = con.createStatement()
        println("Actualiza una fila")
        println("Introduce el nuevo nombre:")
        val nombre = Scanner(System.`in`).nextLine()
        println("Introduce la nueva contraseña:")
        val pass = Scanner(System.`in`).nextLine()
        println("Introduce el email:")
        val email = Scanner(System.`in`).nextLine()
        selectAll()
        st.executeUpdate("UPDATE USUARIO SET Nombre = '$nombre', Password = '$pass' WHERE Email = '$email'");
        selectAll()
        st.close()
        con.close()
    } catch (e: SQLException) {
        println("Aun no existe la tabla")
        showMenu()
    }
}