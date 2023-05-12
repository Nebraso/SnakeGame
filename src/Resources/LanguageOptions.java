package Resources;

/**
 *
 * @author NebrasK
 */
public class LanguageOptions {

    public static String[] title = {
        "Snake Game",
        "Schlangenspiel",
        "Змеиная игра", //For more Languages add new options here
    };
    public static String[][] menu = {
        {
            "Action",
            "Aktionen",
            "Действие",}, //For more Languages add new options here
    };
    public static String[][] actionItems = {
        {
            "Add New Snake",
            "Remove Snake",
            "Exit",
        },
        {
            "Neue Schlange",
            "Schlange loschen",
            "Beenden",
        },
        {
            "Добавить новую змею",
            "удалить змею",
            "Выход",
        }
    //For more Languages add new options here
    };
    public static String[] langaugeOptions = {
        "English",
        "Deutsch",
        "Русский", //For more Languages add new options here
    };
    public static String[] ClosingMessage = {
        "Do you want to close the program?",
        "Soll das Programm wirklich beendet werden?",
        "Хотите ли вы закрыть программу?", //For more Languages add new options here
    };

    public static String[][] listOfErrorMessages = {
        {
            "Snake Name shouldn't be empty",
            "Total Length must be >0 ",
            "Head's length must be >0 ",
            "Snake's total length must be >= from Snake's length"
        },
        {
            "Schlangenname sollte nicht leer sein",
            "Gesamtlänge muss >0 sein",
            "Kopflänge muss >0 sein",
            "Die Gesamtlänge der Schlange muss >= von der Länge der Schlange sein"
        },
        {
            "имя змеи не должно быть пустым",
            "общая длина должна быть >0",
            "длина головы должна быть >0",
            "Общая длина змеи должна быть >= длины змеи"
        }
    //For more Languages add new options here
    };

    public static String[] ClosingPanelTitle
            = {
                "Close",
                "Beenden",
                "Конец"
            };
    public static String[][] YesOrNo = {
        {"Yes", "No"},
        {"Ja", "Nein"},
        {"Да", "нет"}
    //For more Languages add new options here
    };
    public static String[][] listOfColors = {
        {
            "Red",
            "Black",
            "Yellow",
            "Green",
            "Blue",
            "Magenta",
            "Cyan"
        },
        {
            
            "Rot",
            "Schwarz",
            "Gelb",
            "Grün",
            "Blau",
            "Magenta",
            "Cyan"
        },
        {
            "Красный",
            "черный",
            "Желтый",
            "Зеленый",
            "Синий",
            "Пурпурный",
            "Голубой"
        }
    //For more Languages add new options here
    };

    public static String[][] addNewSnakeOptions = {
        {
            "Name", "Total Length", "Length of Head", "Color"
        },
        {
            "Name", "Gesamte Lange", "Lange des Kopfes", "Farbe"
        },
        {
            "Имя", "Общая длина", "Длина головы", "Цвет"
        }
    //For more Languages add new options here

    };
    public static String[][] sliderLabels = {
        {
            "Slower", "Faster",},
        {
            "Langsmer", "Schneller",},
        {
            "Помедленнее", "Быстрее",}
    //For more Languages add new options here
    };
    public static String[] startStop = {
        "Start/Stop", "Start/Stop", "Старт/Стоп"
    //For more Languages add new options here
    };
}
