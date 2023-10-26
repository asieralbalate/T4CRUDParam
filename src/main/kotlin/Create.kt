package exemples

import java.sql.DriverManager

fun create(){
    val url = "jdbc:sqlite:identifier.sqlite"

    val	con = DriverManager.getConnection(url)

    val st = con.createStatement ()
    st.executeUpdate("CREATE TABLE if not exists USUARIO " +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Nombre varchar(15)," +
            "Usuari varchar(15)," +
            "Password varchar(10)," +
            "Telefono numeric," +
            "Email varchar(50) UNIQUE)")
    st.close()
    con.close()
}