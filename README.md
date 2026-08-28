# Fast Stairs Mod - Minecraft 1.17.1 Fabric

Um mod simples para Minecraft 1.17.1 (Fabric) que permite subir escadas **4 vezes mais rapidamente**.

## Funcionalidades

- **Velocidade de escalada aumentada**: Ao subir escadas, o jogador se move 4x mais rápido verticalmente
- **Configuração embutida**: A velocidade pode ser facilmente alterada no código fonte
- **Funciona apenas em escadas**: A velocidade normal é mantida em todas as outras situações

## Como Configurar a Velocidade

Para alterar a velocidade de escalada:

1. Abra o arquivo `src/main/java/com/faststairs/mod/FastStairsMod.java`
2. Localize a linha:
   ```java
   public static final double STAIR_CLIMB_SPEED_MULTIPLIER = 4.0;
   ```
3. Altere o valor `4.0` para o multiplicador desejado:
   - `1.0` = velocidade normal
   - `2.0` = 2x mais rápido
   - `4.0` = 4x mais rápido (padrão)
   - `8.0` = 8x mais rápido
   - etc.

## Como Adicionar um Ícone Personalizado

1. Crie uma imagem PNG (recomendado 128x128 ou 512x512 pixels)
2. Nomeie o arquivo como `icon.png`
3. Coloque o arquivo em `src/main/resources/assets/fast-stairs/icon.png`
4. Remova os arquivos placeholder (`.placeholder`) se desejar

## Requisitos

- **Minecraft**: 1.17.1
- **Fabric Loader**: 0.11.3 ou superior
- **Fabric API**: 0.46.1+1.17
- **Java**: 16 ou superior

## Compilação

### Usando GitHub Actions (Recomendado)

Este projeto inclui um workflow do GitHub Actions que compila automaticamente o mod:

1. Faça push do código para o repositório no GitHub
2. Acesse a aba "Actions" no GitHub
3. O workflow será executado automaticamente
4. Baixe o arquivo `.jar` dos artifacts

### Compilação Local

```bash
# No Linux/Mac
./gradlew build

# No Windows
gradlew.bat build
```

O arquivo compilado estará em `build/libs/`

## Instalação

1. Baixe o arquivo `.jar` do mod
2. Coloque na pasta `mods` do seu Minecraft
3. Certifique-se de ter o Fabric Loader e Fabric API instalados
4. Inicie o Minecraft com o perfil Fabric

## Estrutura do Projeto

```
fast-stairs/
├── .github/workflows/
│   └── build.yml          # GitHub Actions workflow
├── src/main/
│   ├── java/
│   │   └── com/faststairs/mod/
│   │       ├── FastStairsMod.java      # Classe principal com configuração
│   │       └── mixin/
│   │           └── LivingEntityMixin.java  # Lógica de modificação
│   └── resources/
│       ├── fabric.mod.json             # Metadados do mod
│       ├── fast-stairs.mixins.json     # Configuração de mixins
│       └── assets/fast-stairs/
│           └── icon.png                # Ícone do mod (a adicionar)
├── build.gradle                        # Configuração do Gradle
├── gradle.properties                   # Propriedades do projeto
└── gradlew                             # Script de build
```

## Licença

MIT License - Sinta-se livre para modificar e distribuir.

## Suporte

Para problemas ou sugestões, abra uma issue no repositório do GitHub.
