# simulation_v1_1

СИМУЛЯЦИЯ

Проект с консольным выводом информации.

На старте формируется "игровое" поле на котором 10% площади суммарно занимают Камни, Деревья, Трава, Хищники и Травоядные.
Сущности в рамках предназначенного им общего объема распределяются равными долями.

Цель: Хищники должны съесть всех травоядных а Травоядные - всю траву.
Сумялиция игрового мира заканчивается когда не осталось либо травы либо травоядных.
В процессе симуляции можно ставить ее на паузу и затем продолжать с места остановки.

Для нахождения кратчайшего пути от объекта к его цели (например Травоядного к Траве) реализован механиз "Поиск в ширину", при этом объект не может ходить по занятым клеткам,
а вынужден искать кратчайший путь с учетом препятствий на его пути.
![image](https://github.com/RomanV79/simulation_v1_1/assets/121058298/3da0d06e-561a-4757-9e6a-dd90d752d881)



Для запуска приложения из консоли windows выполните следующие действия:
1. Подготовьте консоль чтобы она корректно отображало строки в UTF-8 .
  Наберите пооочередно в консоли:
  REM change CHCP to UTF-8
  CHCP 65001
  ![image](https://github.com/RomanV79/simulation_v1_1/assets/121058298/bfff3aa5-fd2f-4c3a-980e-066310a15a96)
  
 2. Далее запустите приложение стандартным способом: java -jar "полный путь до исполняемого файла"
    ![image](https://github.com/RomanV79/simulation_v1_1/assets/121058298/20e10b49-293b-45d8-9b43-9a92439939dc)

Предварительно соберите проект при помощи MAVEN.
