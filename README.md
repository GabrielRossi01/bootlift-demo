# bootlift-demo

API de biblioteca em Spring Boot 3.5 usada para demonstrar o
[Bootlift](https://github.com/GabrielRossi01/bootlift), uma GitHub Action que
mede o quanto o projeto está pronto para o Spring Boot 4.

O projeto já está quase migrado: só falta trocar `spring-boot-starter-web` por
`spring-boot-starter-webmvc` e subir a versão do Boot. Esses achados aparecem no
relatório, mas não reprovam nenhum PR. O Bootlift só bloqueia o que um PR
**adiciona** e, quando a correção é certa, sugere a linha corrigida em 1 clique.

Veja a action em ação nos [pull requests](../../pulls?q=is%3Apr).
