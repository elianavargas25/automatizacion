
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String


def static "co.com.quipux.wat.checkDataBase.checkDB"(
    	String url	
     , 	String dbname	
     , 	String port	
     , 	String username	
     , 	String password	) {
    (new co.com.quipux.wat.checkDataBase()).checkDB(
        	url
         , 	dbname
         , 	port
         , 	username
         , 	password)
}

def static "co.com.quipux.wat.checkDataBase.connectDB"(
    	String url	
     , 	String dbname	
     , 	String port	
     , 	String username	
     , 	String password	) {
    (new co.com.quipux.wat.checkDataBase()).connectDB(
        	url
         , 	dbname
         , 	port
         , 	username
         , 	password)
}

def static "co.com.quipux.wat.checkDataBase.executeQuery"(
    	String queryString	) {
    (new co.com.quipux.wat.checkDataBase()).executeQuery(
        	queryString)
}

def static "co.com.quipux.wat.checkDataBase.closeDatabaseConnection"() {
    (new co.com.quipux.wat.checkDataBase()).closeDatabaseConnection()
}

def static "co.com.quipux.wat.checkDataBase.execute"(
    	String queryString	) {
    (new co.com.quipux.wat.checkDataBase()).execute(
        	queryString)
}

def static "utils.Aleatorios.retornarNumero"() {
    (new utils.Aleatorios()).retornarNumero()
}

def static "utils.Aleatorios.getTimeStamp"() {
    (new utils.Aleatorios()).getTimeStamp()
}

def static "utils.Aleatorios.retornarPlaca"() {
    (new utils.Aleatorios()).retornarPlaca()
}
