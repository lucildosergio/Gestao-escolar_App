# Run script: compila e executa o launcher
# Uso: execute este script no PowerShell a partir da raiz do projeto

$defaultJdk = 'C:\Program Files\Eclipse Adoptium\jdk-17.0.20.101-hotspot'
$jdk = if ($env:JAVA_HOME) { $env:JAVA_HOME } else { $defaultJdk }
$javac = Join-Path $jdk 'bin\javac'
$java = Join-Path $jdk 'bin\java'

Write-Host "Usando JDK em: $jdk"

if (!(Test-Path out)) { New-Item -ItemType Directory -Path out | Out-Null }

$files = Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
& $javac -encoding UTF-8 -d out $files
if ($LASTEXITCODE -ne 0) { Write-Error "Compilacao falhou (codigo $LASTEXITCODE)"; exit $LASTEXITCODE }

& $java -cp out br.comescola.Launcher
