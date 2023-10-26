package exemples

import java.sql.DriverManager

fun deleteAll(){
    val url = "jdbc:sqlite:identifier.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    st.executeUpdate("DELETE FROM USUARIO")

    st.close()
    con.close()
}