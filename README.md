### Приложение, которое позволяет скачивать произвольную HTML-страницу посредством HTTP-запроса на жесткий диск компьютера и выдает статистику по количеству уникальных слов в консоль.

После запуска приложения Вам будет предложено ввести адрес web-страницы. Если скачивание и сохранение страницы будет произведено успешно, то в консоли появится сообщение об этом и имя созданного файла (в дальнейшем его можно будет найти в корневом пакете приложения). Далее уникальные слова состраницы не только выведутся в консоль, но также сохранятся в БД. На данный момент приложение настроено таким образом, что слова сохраняются в таблицу statistic с полями word, frequency, url в базе данных ss. Поэтому для работы приложения необходимо создать подобную БД и таблицу и изменить под себя доступ в классе HibernateUtil (если хотите использовать другие названия таблицы/полей, то измените аннотации в классе Statistic.java).
Информацию об ошибках можно найти в файле log_file, который находится в корневом пакете приложения.