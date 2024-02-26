Название ролей обязательно должно начинаться со слова ROLE (ROLE_USER)

Для активации defaultSuccessUrl при конфигурации formLogin нужно обязательно после указания эндпоинта - написать true. Пример(.defaultSuccessUrl("/", true))

Начинать http.formLogin с loginProcessingUrl("/auth")

Модель User имплеминтируется от UserDetails

Модель Role имплементируется от GrantedAuthority

В UserRepository будет создан запрос по поиску по email пользователя, который является логином входа (User findByEmail(String email);)
