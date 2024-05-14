import java.util.ArrayList;
import java.util.List;

public class Task_2 {
    public static class Paragraph {
        private String content;

        public Paragraph(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void addText(String text) {
            content += text;
        }

        public int wordCount() {
            String[] words = content.split("\\s+");
            return words.length;
        }
    }

    public static class Page {
        private List<Paragraph> paragraphs;

        public Page() {
            this.paragraphs = new ArrayList<>();
        }

        public void addParagraph(Paragraph paragraph) {
            paragraphs.add(paragraph);
        }

        public void removeParagraph(Paragraph paragraph) {
            paragraphs.remove(paragraph);
        }

        public void displayContent() {
            for (Paragraph paragraph : paragraphs) {
                System.out.println(paragraph.getContent());
            }
        }

        public int paragraphCount() {
            return paragraphs.size();
        }
    }

    public static void main(String[] args) {
        Paragraph paragraph1 = new Paragraph("This is the first paragraph. ");
        Paragraph paragraph2 = new Paragraph("This is the second paragraph. ");
        Paragraph paragraph3 = new Paragraph("This is the third paragraph. ");

        Page page = new Page();
        page.addParagraph(paragraph1);
        page.addParagraph(paragraph2);
        page.addParagraph(paragraph3);

        page.displayContent();
        System.out.println("Number of paragraphs: " + page.paragraphCount());
        System.out.println("Total words: " + totalWords(page));
    }

    public static int totalWords(Page page) {
        int totalWords = 0;
        for (Paragraph paragraph : page.paragraphs) {
            totalWords += paragraph.wordCount();
        }
        return totalWords;
    }
}