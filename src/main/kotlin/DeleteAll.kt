package exemples

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

fun deleteAll(){
    val url = "jdbc:sqlite:identifier.sqlite"
    val con: Connection

    try {
        con = DriverManager.getConnection(url)

        val st = con.createStatement()

        st.executeUpdate("DELETE FROM USUARIO")

        st.close()
        con.close()
    } catch (e: SQLException) {
        println("Aun no existe la tabla")
        showMenu()
    }
}