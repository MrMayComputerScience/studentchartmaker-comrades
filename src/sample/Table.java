package sample;

public class Table {

    private String header;
    private String[] columns;
    private String[] names;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public Table(String header, String[] columns, String[] names) {
        setHeader(header);
        setColumns(columns);
        setNames(names);
    }
}
