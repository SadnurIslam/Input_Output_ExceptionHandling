
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Test

{

    public static void main(String[] args)

    {
        try (Scanner in = new Scanner(new File("hello.txt")))

        {

            String message = in.nextLine();
            System.out.println(message);

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();

        }
        try (PrintWriter out = new PrintWriter("hello.txt"))
        {
            out.println("Hello, World!");

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();

        }

    }

}

#########2

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.PrintWriter;
        import java.util.Scanner;
        import java.util.ArrayList;
public class BlankLinesRemover
{
    public static void removeLines(String fileName)
    {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner in = new Scanner(new File(fileName)))
        {
            while (in.hasNextLine())
            {
                String line = in.nextLine();
                if (!line.trim().isEmpty())
                {
                    lines.add(line);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(fileName))
        {
            for (String line: lines)
            {
                out.println(line);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
Filename: “Test.java”
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.PrintWriter;
        import java.util.Scanner;
public class Test
{
    public static void main(String[] args)
    {
        BlankLinesRemover.removeLines("lines.txt");
        int count = 0;
        try (Scanner in = new Scanner(new File("lines.txt")))
        {
            while (in.hasNextLine())
            {
                in.nextLine();
                count++;
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println("Number of non-blank lines: " + count);
        System.out.println("Expected: 10");
    }
}

        ################ 3


        Filename: “FileTrimmer.java”
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.PrintWriter;
        import java.util.Scanner;
        import java.util.ArrayList;
        import java.util.ListIterator;

public class FileTrimmer

{
    public static void trimBlankLines(String fileName)

    {
        ArrayList<String> lines = new ArrayList<>();
        boolean nonBlankFound = false;
        try (Scanner in = new Scanner(new File(fileName)))

        {
            while (in.hasNextLine())

            {
                String line = in.nextLine();
                if (!line.trim().isEmpty() || nonBlankFound)

                {
                    nonBlankFound = true;
                    lines.add(line);
                }

            }

        }
        catch (FileNotFoundException e)

        {
            e.printStackTrace();

        }
        ListIterator<String> it = lines.listIterator(lines.size());
        while (it.hasPrevious() && it.previous().trim().isEmpty())

        {
            it.remove();

        }
        try (PrintWriter out = new PrintWriter(fileName))

        {
            for (String line: lines)

            {
                out.println(line);

            }

        }
        catch (FileNotFoundException e)

        {
            e.printStackTrace();

        }

    }

}
 import java.io.File;

        import java.io.FileNotFoundException;

        import java.io.PrintWriter;

        import java.util.Scanner;

public class Test

{
    public static void main(String[] args) {
        FileTrimmer.trimBlankLines("lines.txt");

        int count = 0;
        try (Scanner in = new Scanner(new File("lines.txt"))) {
            while (in.hasNextLine()) {
                in.nextLine();
                count++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

        System.out.println("Number of non-blank lines: " + count);

        System.out.println("Expected: 12");

    }

}


        ############# 4


        import java.io.*;
        import java.util.Scanner;
public class LineNumbers
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the file name for input: ");
        String filename1 = in.next();
        System.out.print("Please enter the file name for output: ");
        String filename2 = in.next();
        try (Scanner inFile = new Scanner(new File(filename1)); PrintWriter out = new PrintWriter(filename2))
        {
            int count = 1;
            while (inFile.hasNext())
            {
                out.println("/* " + count + " */ " + inFile.nextLine());
                count++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }
}

        ########## 5
        import java.io.*;
        import java.util.Scanner;
public class LineNumbers

{
    public static void main(String[] args)

    {
        Scanner in = new Scanner(System.in);
        String filename1 = null;
        if (args.length == 1)

        {
            filename1 = args[0];

        }

        else
        {
            System.out.print("Please enter the file name for input: ");
            filename1 = in.next();
        }

        System.out.print("Please enter the file name for output: ");
        String filename2 = in.next();
        try (Scanner inFile = new Scanner(new File(filename1)); PrintWriter out = new PrintWriter(filename2))

        {
            int count = 1;
            while (inFile.hasNext())

            {
                out.println("/* " + count + " */ " + inFile.nextLine());
                count++;

            }

        }

        catch (FileNotFoundException e)

        {
            System.out.println("File not found!");

        }

    }

}


############# 6

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.Scanner;
public class AverageColumns
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the file name: ");
        String filename = in.next();
        try (Scanner inFile = new Scanner(new File(filename)))
        {
            double sum1 = 0.0;
            double sum2 = 0.0;
            int count = 0;
            while (inFile.hasNextDouble())
            {
                sum1 += inFile.nextDouble();
                sum2 += inFile.nextDouble();
                count++;
            }
            System.out.println("Average of column 1: " + sum1 / count);
            System.out.println("Average of column 2: " + sum2 / count);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }
}

        ################# 7

        import java.io.FileReader;
        import java.io.FileWriter;
        import java.io.IOException;
class GFG
    public static void main(String[] args) //
    {
        attempt
        {
            FileReader fr = new FileReader("gfgInput.txt");
            FileWriter fw = new FileWriter("gfgOutput.txt");
            String str = "";
            int i;
            while ((i = fr.read()) != -1)
            {
                str += (char)i;
            }
            System.out.println(str);
            fw.write(str);
            fr.close();
            fw.close();
            System.out.println(  "File reading and writing both done");
        }
    catch (IOException e)
        {    // If there is no file in specified path
            System.out.println(     "There are some IOException");
        }

    }
}



project:
        ######## 1

        import java.io.File;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.Scanner;
public class BabyNames
{ public static String processName(Scanner in)
    {
        String name = in.next();
        int count = in.nextInt();
        double percent = in.nextDouble();
        return name;
    }
    public static void main(String[] args)
    {
        try (Scanner in = new Scanner(new File("babynames.txt"));
             PrintWriter boyOut = new PrintWriter("boynames.txt");
             PrintWriter girlOut = new PrintWriter("girlnames.txt"))
        {
            while (in.hasNextInt())
            {
                int rank = in.nextInt();
                boyOut.println(processName(in));
                girlOut.println(processName(in));
            }
            System.out.println("The program runs successfully");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
    Sample Output
    Input filename: “babynames.txt”


        ####### 2

        import java.io.File;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Scanner;


public class DualGenderNames

{
    public static String processName(Scanner in) {
        String name = in.next();
        int count = in.nextInt();
        double percent = in.nextDouble();
        return name;
    }

    public static void printSameNames(ArrayList<String> boyNames, ArrayList<String> girlNames)

    {
        for (String name : boyNames)

        {
            if (girlNames.contains(name))

            {
                System.out.println(name);

            }

        }

    }

    public static void main(String[] args)

    {
        try (Scanner in = new Scanner(new File("babynames.txt")))
        {
            ArrayList<String> boyNames = new ArrayList<String>();
            ArrayList<String> girlNames = new ArrayList<String>();
            while (in.hasNextInt())
            {
                int rank = in.nextInt();
                boyNames.add(processName(in));
                girlNames.add(processName(in));
            }

            printSameNames(boyNames, girlNames);

        }
        catch (IOException e)
        {
            e.printStackTrace();

        }

    }

}

############ 3

        Program:
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.Scanner;
public class WebGet
{
    public static void dumpScannerToFile(Scanner in, String filename)
    {
        try (PrintWriter outfile = new PrintWriter(filename))
        {
            while (in.hasNextLine())
            {
                String line = in.nextLine();
                outfile.println(line);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot write to file " + filename);
        }
    }
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the url to scan: ");
        String url = console.nextLine();
        System.out.println("Enter the file to write to: ");
        String fileName = console.nextLine();
        URL locator;
        try
        {
            locator = new URL(url);
            try (Scanner in = new Scanner(locator.openStream()))
            {
                dumpScannerToFile(in, fileName);
            }
            catch (IOException e)
            {
                System.out.println("IO Exception!");
            }
        }
        catch (MalformedURLException e)
        {
            System.out.println("Invalid URL.");
        }
    }
}



        ########## 4

        import java.util.ArrayList;
        import java.util.Scanner;
        import java.io.*;
public class CSVReader
{
    private ArrayList<String> rows;
    public CSVReader(String fileName)
    {
        rows = new ArrayList<>();
        try (Scanner inFile = new Scanner(new File(fileName)))
        {
            while (inFile.hasNext())
            {
                rows.add(inFile.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }
    public int numberOfRows()
    {
        return rows.size();
    }
    public int numberOfFields(int row)
    {
        if (row < 0 || row >= rows.size())
        {
            throw new IllegalArgumentException("Row: " + row);
        }
        return getFields(row).size();
    }
    private ArrayList<String> getFields(int row)
    {
        ArrayList<String> fields = new ArrayList<>();
        Scanner line = new Scanner(rows.get(row));
        line.useDelimiter(",");
        while (line.hasNext())
        {
            String field = line.next().trim();
            if (field.startsWith("\""))
            {
                while (!field.endsWith("\""))
                {
                    field = field + "," + line.next();
                }
                field = field.substring(1,field.length() - 1);
            }
            field = field.replaceAll("\"\"","\"");
            fields.add(field);
        }
        return fields;
    }
    public String field(int row, int column)
    {
        if (row < 0 || row >= rows.size())
        {
            throw new IllegalArgumentException("Row: " + row);
        }
        if (column < 0 || column >= numberOfFields(row))
        {
            throw new IllegalArgumentException("Column: " + column);
        }
        return getFields(row).get(column);
    }
}
Filename: “CSVReaderTester.java”
public class CSVReaderTester
{
    public static void main(String[] args)
    {
        CSVReader reader1 = new CSVReader("att2007.csv");
        CSVReader reader2 = new CSVReader("quotes.csv");
        System.out.println("Number of rows: " + reader1.numberOfRows());
        System.out.println("Expected: 214");
        System.out.println("Number of fields in row 10: " + reader1.numberOfFields(10));
        System.out.println("Expected: 7");
        System.out.println("Row 10, Col 2: " + reader1.field(10, 2));
        System.out.println("Expected: 24.95");
        System.out.println("Number of rows: " + reader2.numberOfRows());
        System.out.println("Expected: 2");
        System.out.println("Number of fields in row 1: " + reader2.numberOfFields(1));
        System.out.println("Expected: 4");
        System.out.println("Row 1, Col 2: " + reader2.field(1, 2));
        System.out.println("Expected: Hello, World");
        System.out.println("Row 1, Col 3: " + reader2.field(1, 3));
        System.out.println("Expected: He asked: \"Quo vadis?\"");
        System.out.println("Row 0, Col 3: " + reader2.field(0, 3));
        System.out.println("Expected: \"..., that all men are created equal, ...\"");
    }
}
  