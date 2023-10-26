package exemples

import java.sql.DriverManager
import java.util.*

fun delete(){
    val url = "jdbc:sqlite:identifier.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    println("Borra una fila segun su id")
    println("Introduce el id:")
    val idMenu = Scanner(System.`in`).nextLine()

    val sql = "DELETE FROM USUARIO WHERE ID = $idMenu"
    st.executeUpdate(sql)

    selectAll()
    st.close()
    con.close()
}