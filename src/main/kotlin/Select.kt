package exemples

import java.sql.DriverManager
import java.util.*

fun select(){
    val url = "jdbc:sqlite:identifier.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    println("Introduce los campos a filtrar separados por comas si quieres ver todo introduce *")
    val input = Scanner(System.`in`).nextLine()

    if (input.equals('*')) {
        val sentenciaSQL = "SELECT * FROM USUARIO"
    } else {
        val items = input.split(",")
    }

    val sentenciaSQL = "SELECT * FROM USUARIO"
    val rs = st.executeQuery(sentenciaSQL)

    System.out.println("ID. \tNombre \tUser \tPassword \tTelefono \tEmail")
    System.out.println("---------------------------------------------------------")

    var rowCount = 0
    while (rs.next()) {
        print("" + rs.getInt(1) + "\t")
        print("" + rs.getString(2) + "\t")
        print("" + rs.getString(3) + "\t")
        print("" + rs.getString(4) + "\t")
        print("" + rs.getDouble(5) + "\t")
        println("" +rs.getString(6) + "\t")
        rowCount++
    }

    println("Número de registros: $rowCount")

    rs.close()
    st.close()
    con.close()
}