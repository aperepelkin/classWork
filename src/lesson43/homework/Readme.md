#Задание:
Есть одна регистратура из которой приходят пациенты ко врачам со скоростью около 1 чел/с (случайное значение). Врачей **N** штук, они принимают следующего пациента как только освобождаются
Один врач не может принимать одновременно 2-х или более пациентов, и один пациент не может быть на приеме у нескольких врачей.Когда пациент заходит в кабинет, на экран вывестии сообщение "пациент 2 зашел в кабинет 4", после завершения приема - "пациент 2 вышел из кабинета 4" прием длится около **N+1** секунд (случайное значение). 40% пациентов идут на повторный прием (через 1с после выхода из кабинета). Если пациент пришел второй раз, то при входе в кабинет добавить к сообщению какой раз он зашел.После 2-минут работы кабинеты закрываются, когда остается открытым один кабинет, регистратура закрывается(больше пациентов не приходит) и последний кабинет принимает всех оставшихся, на повторный прием более никто не уходит.

#####После завершения вывести на экран:
- количество пришедших уникальных пациентов
- количество повторных приемов
- сколько всего каждый врач принял людей (вкл повторных)
- пациента с максимальным количеством повторных приемов.
- вывести максимальное ожидание пациента врачем (для каждого врача)

#Модификация 1
Открылось 2 регистратуры, теперь каждая, независимо друг от друга, отправляет ко врачам людей со скоростью около 1 чел/с (случайное значение).

#Модификация 2
Регистратуры стали сразу назначать врача пациенту, теперь если врач занят пациента не может принять другой врач, он должен стоять в очереди к назначеному. Врачи не могут просто по прошествии около 2-х минут прекратить работу. Они должны принять всех пациентов в своей очереди, но по сигналу что врач завершил работу регистратура не может отправлять к ним пациентов.

#Модификация 3
У врачей появилось **N-4** или **2** кабинета рентгена которые они могут занимать при приеме для 30% пациентов. Дополнительно вывести сколько раз каждый врач воспользовался рентгеном и вывести сколько раз воспользовались каждыс рентгеном в сумме 