# 📦 GitHub Repository Explorer

Projekt Java z użyciem Spring Boot, umożliwiający pobieranie informacji o repozytoriach i branchach użytkownika GitHuba przy użyciu GitHub REST API.

---

## 🔧 Technologie

- Java 21
- Spring Boot 3.5.3
- Spring Web
- RestClient (Spring's new HTTP client)
- Maven (lub Gradle)
- JUnit 5 (do testów)

---

## 🚀 Funkcjonalności

- Pobieranie listy repozytoriów dla wskazanego użytkownika GitHuba.
- Wyświetlanie podstawowych informacji: nazwa repozytorium, login właściciela.
- Pobieranie listy branchy i ich ostatnich commitów.

---


## ⚙️ Jak uruchomić

### 1. Sklonuj repozytorium

```bash
git clone https://github.com/TwojeKonto/apitiera-java.git
cd apitiera-java 
```
### 2. Uruchom aplikacje

```bash
./mvnw spring-boot:run
```

---

## 🧪 Jak testować

Uruchom wszystkie testy:

```bash
./mvnw test
```

---

## ❗ Uwaga dotycząca autentykacji

Projekt nie obsługuje autentykacji do GitHub API, ponieważ nie było to wymagane w założeniach projektu.

GitHub nakłada ograniczenia na niezautoryzowane zapytania:

`The primary rate limit for unauthenticated requests is 60 requests per hour per IP address.`

Oznacza to, że po przekroczeniu tego limitu kolejne zapytania będą odrzucane z kodem `HTTP 403 Forbidden`.