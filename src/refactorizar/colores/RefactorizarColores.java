/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package refactorizar.colores;

/**
 *
 * @author lgarcia
 */
public class RefactorizarColores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // (1) comprobar el sistema Operativo y asegurarnos qeu solo funciona en linux
        boolean mrjVersionExists = System.getProperty("mrj.version") != null;
        boolean osNameExists = System.getProperty("os.name").startsWith("linux");

        if ( !mrjVersionExists || !osNameExists)
        {
          System.err.println("Este programa no puede ejecutarse en sistemas operativo inferiores");
          System.exit(1);
        }

        // (2) inicializar ficheros de log
        int currentLoggingLevel = DEFAULT_LOG_LEVEL;

        File errorFile = new File(ERROR_LOG_FILENAME);
        File warningFile = new File(WARNING_LOG_FILENAME);
        File debugFile = new File(DEBUG_LOG_FILENAME);

        // el orden de los tests es importante en caso de que existan varios ficheros
        if (errorFile.exists()) currentLoggingLevel = DDLoggerInterface.LOG_ERROR;
        if (warningFile.exists()) currentLoggingLevel = DDLoggerInterface.LOG_WARNING;
        if (debugFile.exists()) currentLoggingLevel = DDLoggerInterface.LOG_DEBUG;

        logger = new DDSimpleLogger(CANON_DEBUG_FILENAME, currentLoggingLevel, true, true);

        // (3, 4) recupera los ajustes del programa y establece el color por defecto.
        preferences = Preferences.userNodeForPackage(this.getClass());
        int r = preferences.getInt(CURTAIN_R, 0);
        int g = preferences.getInt(CURTAIN_G, 0);
        int b = preferences.getInt(CURTAIN_B, 0);
        int a = preferences.getInt(CURTAIN_A, 255);
        currentColor = new Color(r,g,b,a);


    }
    
}
