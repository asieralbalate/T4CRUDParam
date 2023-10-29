package exemples

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

fun select() {
    val url = "jdbc:sqlite:identifier.sqlite"
    val con: Connection

    try {
        con = DriverManager.getConnection(url)
        val st = con.createStatement()

        println("Introduce los campos a filtrar separados por comas si quieres ver todo introduce *")
        val input = Scanner(System.`in`).nextLine()


        if (input.equals('*')) {
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
                println("" + rs.getString(6) + "\t")
                rowCount++
            }

            println("Número de registros: $rowCount")
            rs.close()
        } else {
            val niceInput = if (input.endsWith(",")) input.removeSuffix(",") else input
            val sentenciaSQL = "SELECT $niceInput FROM USUARIO"
            val rs = st.executeQuery(sentenciaSQL)

            val metaData = rs.metaData
            val columnCount = metaData.columnCount


            var header = ""
            for (i in 1..columnCount) {
                header += metaData.getColumnName(i) + "\t"
            }
            println("")
            println(header)

            var rowCount = 0
            while (rs.next()) {
                for (i in 1..columnCount) {

                    val columnType = metaData.getColumnType(i)

                    if (columnType == java.sql.Types.INTEGER) {
                        print("" + rs.getInt(i) + "\t")
                    } else if (columnType == java.sql.Types.DOUBLE) {
                        print("" + rs.getDouble(i) + "\t")
                    } else {
                        print("" + rs.getString(i) + "\t")
                    }
                }
                println("")
                rowCount++
            }
            println("Número de registros: $rowCount")
            println("")
            rs.close()
        }

        st.close()
        con.close()
    } catch (e: SQLException) {
        println("No existe aun la tabla")
        showMenu()
    }
}