package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day,String month,String year){

        // Выбрать месяц
        $(".react-datepicker__month-select").selectOption(month);
        // Выбрать год
        $("[class=react-datepicker__year-select]").selectOption(year);
        // Клик по дню
        $(".react-datepicker__day--0"+day).click();
    }
}
