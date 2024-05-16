 Разработано Android приложение, которое генерирует случайное число, подчиняющееся логнормальному закону распределения. Оснавная часть с условиями поставленной задачи находится в файле MainActivity.kt.

Описание разработанного решения. На главном и единственном экране размещено поле прокрутки и два 
поля для ввода значений μ и σ². При нажатии на кнопку с @id/get_random_num в текстовом
поле с @id/random_number_result выводится строчное значение числа, которое было рассчитано
по закону логнормального распределения для введенных μ и σ². Данные в ViewModel сохраняются даже
после поворота экрана, поэтому я использовала ViewModel для хранения сгенерированного числа.
Когда пользователь нажимает кнопку "Получить случайное число", я получаю значения среднего и
дисперсии из EditText и вычисляю случайное число с использованием функции getLogNormalRandomValue.
Затем я сохраняю случайное число в ViewModel, чтобы оно сохранилось после поворота экрана. Добавлена
проверка null для savedNumber при загрузке сохраненного числа. Это необходимо, потому что
ViewModel создается заново при повороте экрана, и savedNumber изначально будет null.

В файле ExampleUnitTest.kt хранятяться unit-тесты (4 штуки), которые проверяют работу приложения и формулы на корректность.Также подключены готовые ui-тесты со свеми необходимыми зависимостями. 

После выгрузки проекта на github бало создано две ветки: develop и master. Ветка master является основной и в нее дополнительно был добавлен файл main.yml в папку .github/workflows для автосборки и тестирования кода. 