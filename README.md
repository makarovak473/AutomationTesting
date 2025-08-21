# 🧪 QA Automation Framework - AutomationExercise

Acesta este un framework de testare automată end-to-end construit în **Java**, folosind **Selenium WebDriver**, **TestNG** și **Allure Reports**.  
Framework-ul implementează design pattern-ul **Page Object Model (POM)** pentru o structură clară și scalabilă a testelor.  

---

## ⚙️ Tehnologii utilizate
- **Java 17+**
- **Maven** - build management & dependency management
- **Selenium WebDriver** - interacțiune cu browserul
- **TestNG** - framework pentru scriere și rulare teste
- **Allure Reports** - raportare testare cu grafice și atașamente
- **Page Object Model (POM)** - structură modulară pentru pagini
- **JSON** - pentru gestionarea datelor de test

---

## 📂 Structura proiectului
src

├── main

│ └── java

│ ├── models # modele pentru date (ex: Credentials)

│ ├── pages # clase Page Object pentru fiecare pagină

│ └── utils # utilitare (ex: DriverFactory)

└── test

└── java

├── tests # clasele de test

└── utils # TestListener (pentru screenshot-uri la fail)


📝 Exemple de Teste

Login cu date corecte / greșite

Creare cont nou

Creare cont cu email existent

Ștergere cont

Logout

📊 Rapoarte Allure
Generare și vizualizare raport:

bash:
mvn allure:serve

Aceasta va porni un server local și va deschide raportul în browser, unde poți vedea:

✅ Teste trecute

❌ Teste picate

⚠️ Teste sărite

📈 Statistici & grafice



