# Gestão Escolar - App

Aplicação de exemplo em Java (Swing) para gerenciamento básico de espaços e recursos educacionais.

Compilação e execução (Windows PowerShell)

1. Abra um PowerShell na raiz do projeto.

2. Compile todos os fontes com codificação UTF-8:

```powershell
# usando JAVA_HOME se definido, caso contrário ajuste o caminho do JDK
$javac = if ($env:JAVA_HOME) { Join-Path $env:JAVA_HOME 'bin\javac' } else { 'C:\Program Files\Eclipse Adoptium\jdk-17.0.20.101-hotspot\bin\javac' }
& $javac -encoding UTF-8 -d out (Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object FullName)
```

3. Execute o aplicativo (classe `br.comescola.Launcher`):

```powershell
$java = if ($env:JAVA_HOME) { Join-Path $env:JAVA_HOME 'bin\java' } else { 'C:\Program Files\Eclipse Adoptium\jdk-17.0.20.101-hotspot\bin\java' }
& $java -cp out br.comescola.Launcher
```

Observações:
- Requer JDK 8 ou superior (recomenda-se Java 17+).
- Se preferir, abra o projeto em uma IDE (IntelliJ/Eclipse) e execute a classe `br.comescola.Launcher`.

