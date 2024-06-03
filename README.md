# Aplicativo Android de Gateway SMS

Este projeto é um aplicativo móvel desenvolvido com Android Studio que funciona como um gateway para receber mensagens SMS de um dispositivo rastreador. Ele utiliza a versão 14 do Android.

## Requisitos

- Android Studio
- Java Development Kit (JDK)
- Emulador Android ou Dispositivo Físico com Android 14
- Backend API em execução

## Instalação

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
    ```

2. **Configure o ambiente de desenvolvimento:**

Certifique-se de que o Java está instalado e configurado no seu sistema. Você pode verificar a instalação do Java com o seguinte comando:

```bash
java -version
```

Deve retornar algo como:

```bash
java version "17.0.1" 2021-10-19 LTS
Java(TM) SE Runtime Environment (build 17.0.1+12-LTS-39)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.1+12-LTS-39, mixed mode, sharing)
```

Abra o Android Studio e importe o projeto.

3. **Instale as dependências:**

O Android Studio gerenciará as dependências do projeto automaticamente através do Gradle.

4. **Execute o projeto:**

Conecte um dispositivo físico ou configure um emulador no Android Studio e execute o projeto clicando no botão "Run".

**Problemas Comuns**

**Java não instalado**

Se o Java não estiver instalado ou configurado corretamente, você pode enfrentar problemas ao tentar compilar ou executar o aplicativo. Certifique-se de que o JDK está instalado e configurado no PATH do sistema.

**API não ligada**

O aplicativo depende de uma API backend em execução. Certifique-se de que a API está ligada e acessível. Se a API não estiver em execução, o aplicativo não conseguirá buscar dados e você verá erros relacionados à falta de conexão.

**URL da API apontando para a porta errada**

Se a URL da API estiver configurada incorretamente, o aplicativo não conseguirá se comunicar com o backend. Verifique a configuração da URL da API e certifique-se de que ela aponta para o endereço e porta corretos onde a API está em execução.

**Permissões não concedidas**

Se as permissões necessárias não forem concedidas, o aplicativo não poderá receber ou ler mensagens SMS. Certifique-se de que as permissões foram concedidas nas configurações do dispositivo

**Contribuindo**

Faça um fork do projeto.

Crie uma nova branch (git checkout -b feature/sua-feature).

Commit suas mudanças (git commit -am 'Adiciona nova feature').

Faça push para a branch (git push origin feature/sua-feature).

Crie um novo Pull Request.
