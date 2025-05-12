# todo-core
### Cria pacote java em container
```bash
docker run --rm -v .:/core -w /core maven:3.9.9-ibm-semeru-21-jammy bash -c "mvn clean package -DskipTests"
```