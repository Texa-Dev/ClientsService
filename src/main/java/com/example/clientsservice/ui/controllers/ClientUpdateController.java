package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientUpdateController {
    @Autowired
    @Qualifier(value = "clientServiceDb")
    ClientService clientService;

    @GetMapping("clientUpdate")
    public String load(Model model, @RequestParam("id") Integer id){
        Client client = clientService.findById(id);
        model.addAttribute("client",client);
        return "clientUpdate";
    }

    @PostMapping("clientUpdate")
    public String clientUpdate(Model model, @RequestParam("id") Integer id){
        Client client = clientService.findById(id);
        model.addAttribute("client",client);
        return "clientUpdate";
    }
}

/*Для отправки данных из формы в Thymeleaf и создания объекта на основе отправленных данных необходимо выполнить несколько шагов.

Определите форму HTML в вашем HTML-документе, используя элемент <form>. Установите атрибут method="post" для отправки данных методом POST.

Определите поля ввода в форме, используя элементы <input>. Установите атрибуты name для определения имени поля ввода, которое будет использоваться в процессе отправки данных, и type для определения типа поля ввода.

Включите кнопку отправки формы, используя элемент <button>. Установите атрибут type="submit" для отправки данных формы на сервер.

python
Copy code
<form method="post" th:object="${myObject}" th:action="@{/path/to/handler}">
  <input type="text" name="name" th:field="*{name}">
  <input type="text" name="age" th:field="*{age}">
  <button type="submit">Submit</button>
</form>
Обратите внимание на атрибут th:object="${myObject}". Это связывает вашу HTML-форму с объектом, который вы хотите создать на основе данных формы. Атрибут th:field используется для связывания полей ввода с соответствующими свойствами объекта.

Определите обработчик запроса на стороне сервера, который будет принимать отправленные данные формы и создавать объект на основе этих данных.

Создайте метод контроллера для обработки запроса, используя аннотацию @PostMapping. Установите аннотацию @ModelAttribute для получения данных формы и создания объекта.

less
Copy code
@PostMapping("/path/to/handler")
public String handleFormSubmission(@ModelAttribute MyObject myObject) {
  // выполните необходимую обработку данных
  // верните представление, которое должно отобразиться после обработки формы
}
В этом примере MyObject - это класс, который вы хотите создать на основе данных формы. Вы также можете использовать аннотацию @Valid для проверки корректности введенных данных.*/
