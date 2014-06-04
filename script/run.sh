
set -e
cd "$(dirname $0)/.."

java -cp target/classes:"target/dependency/*" it.xpug.supermarket.main.Main
