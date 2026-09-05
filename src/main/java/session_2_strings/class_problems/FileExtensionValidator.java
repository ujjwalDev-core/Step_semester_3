package session_2_strings.class_problems;

/** Validates an upload against the accepted file extensions. */
public class FileExtensionValidator {
    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }

    public static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected - invalid file type";
        }
        String extension = filename.substring(dotIndex + 1);
        if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected - invalid file type";
    }
}
