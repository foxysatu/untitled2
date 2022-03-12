import javax.swing.*;
import java.util.*;

public class SimpleTableTest extends JFrame
{
    // Данные для таблиц
    private Object[][] array = new String[][] {{ "Книга" , "Романтика", "120" },
            { "Ранобэ"  , "Боевик", "40" },
            { "Манга", "Повседневноть" , "30" }};
    // Заголовки столбцов
    private Object[] columnsHeader = new String[] {"Вариант", "Жанр",
            "КОличесто страниц"};
    public SimpleTableTest() {
        super("Простой пример с JTable");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Простая таблица
        JTable table1 = new JTable(array, columnsHeader);
        // Таблица с настройками
        JTable table2 = new JTable(3, 5);
        // Настройка таблицы
        table2.setRowHeight(30);
        table2.setRowHeight(1, 20);

        table2.setShowVerticalLines(false);

        // Данные для таблицы на основе Vector
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        // Вектор с заголовками столбцов
        Vector<String> header = new Vector<String>();
        // Формирование в цикле массива данных
        for (int j = 0; j < array.length; j++) {
            header.add((String)columnsHeader[j]);
            Vector<String> row = new Vector<String>();
            for (int i = 0; i < array[j].length; i++) {
                row.add((String)array[j][i]);
            }
            data.add(row);
        }
        // Таблица на основе вектора
        JTable table3 = new JTable(data, header);
        // Размещение таблиц в панели с блочным расположением
        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table1));
        contents.add(new JScrollPane(table2));

        // Настройка таблицы table3 - цвет фона, цвет выделения

        // Скрытие сетки таблицы
        table3.setShowGrid(false);
        // contents.add(new JScrollPane(table3));
        contents.add(table3);
        // Вывод окна на экран
        setContentPane(contents);
        setSize(500, 400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleTableTest();
    }
}