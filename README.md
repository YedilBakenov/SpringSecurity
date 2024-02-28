1. Название ролей обязательно должно начинаться со слова ROLE (ROLE_USER)
2. Для активации defaultSuccessUrl при конфигурации formLogin нужно обязательно после указания эндпоинта - написать true. Пример(.defaultSuccessUrl("/", true))
3. Начинать http.formLogin с loginProcessingUrl("/auth")



1. Модель User имплеминтируется от UserDetails
2. Модель Role имплементируется от GrantedAuthority
3. В UserRepository будет создан запрос по поиску по email пользователя, который является логином входа (User findByEmail(String email);)
4. Когда добавляете пароли в таблицу через BCRYPT, то обязательно удаляйте пробелы в таблице в конце
