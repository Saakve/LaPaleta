package views;

/**
 * Save the constans used in views package.
 * @author Saske
 */
public interface Messages {
    final javax.swing.border.Border PADDING_FIELD = javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3);
    final javax.swing.border.Border BORDERLINE_FIELD = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153));
    final javax.swing.border.Border BORDER = javax.swing.BorderFactory.createCompoundBorder(BORDERLINE_FIELD, PADDING_FIELD);
    final javax.swing.border.Border BORDERLINE_FIELD_EXCEPTION = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0));
    final javax.swing.border.Border BORDER_EXCEPTION = javax.swing.BorderFactory.createCompoundBorder(BORDERLINE_FIELD_EXCEPTION, PADDING_FIELD);
    final String ERROR_LOGIN = "Usuario o contraseña incorrectos";
    final String EMPTY_INPUT = "Rellene los campos vacíos";
    final String INVALID_INPUT = "Entradas erróneas";
}
