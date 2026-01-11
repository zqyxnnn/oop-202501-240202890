<!-- Copilot / AI agent instructions for the Agri-POS practicum repository -->
# Copilot instructions — Agri-POS practicum

Purpose: give AI coding agents the minimum, actionable context to work productively in this repo.

- Big picture: This repository is a semester-long set of weekly labs building a small Java "Agri-POS" application. Weekly exercises live in `praktikum/weekX-*`; consolidated/integration code (final project) appears under `src/main/java/com/upb/agripos/`.

- Naming & layout conventions:
  - Weekly modules: `praktikum/weekN-*` — follow the existing pattern (code in `src/main/java`, tests in `src/test/java`, `laporan.md`, `screenshots/`).
  - Package root: `com.upb.agripos` (subpackages follow module/function names, e.g., `model`, `dao`). See docs referencing this package namespace.
  - Reports: each week includes `laporan.md` — do not remove or rename.
  - SQL artifacts live in `sql/` (`schema.sql`, `seed.sql`) and are for PostgreSQL-based DAO exercises.

- Build & test workflows (explicit examples):
  - Most modules are standalone Maven projects. Build or test a specific module from repository root, for example:

    - Run tests for week 10:
      mvn -f praktikum/week10-pattern-testing/pom.xml test

    - Package a module:
      mvn -f praktikum/week10-pattern-testing/pom.xml package

    - Alternatively change directory and run `mvn test` inside the module folder.

  - Tests use JUnit 5 (junit-jupiter). Example test: `praktikum/week10-pattern-testing/src/test/java/com/upb/agripos/ProductTest.java`.

  - To run a compiled main class from a module after packaging:
    1) mvn -f <module>/pom.xml package
    2) java -cp <module>/target/classes com.upb.agripos.YourMainClass

- Project-specific patterns the agent should follow:
  - Keep changes scoped to a single weekly module unless the task explicitly requires integration across modules or `src/main/java`.
  - Tests and educational samples are intentionally simple; prefer minimal, well-commented changes that preserve pedagogical clarity.
  - Maintain Indonesian-language report files and folder names (e.g., `laporan.md`, `screenshots/`) as they are part of deliverables.

- Integration points & external deps:
  - PostgreSQL is used in DAO weeks (check `praktikum/week11-dao-database/` and `sql/schema.sql`). When adding DB code, do not hardcode credentials — document required connection parameters instead.
  - No central CI config detected — assume local Maven execution or IDE run for verification.

- Files to inspect for guidance or examples (use these as canonical references):
  - [README.md](README.md) — repo overview and student workflow
  - [praktikum/week10-pattern-testing/pom.xml](praktikum/week10-pattern-testing/pom.xml) — example Maven module (Java 17, JUnit 5)
  - [praktikum/week10-pattern-testing/src/test/java/com/upb/agripos/ProductTest.java](praktikum/week10-pattern-testing/src/test/java/com/upb/agripos/ProductTest.java) — example unit test style
  - [docs/09_bab9_exception.md](docs/09_bab9_exception.md) — shows package usages and teaching notes
  - [sql/schema.sql](sql/schema.sql) — DB schema for DAO exercises

- When editing or creating code:
  - Preserve existing package names and directory layout.
  - Keep examples short and educational: prefer clarity over micro-optimizations.
  - Add or update tests where behavior changes; follow JUnit 5 style used in existing tests.

- When opening PRs or commits (guidance for the human collaborator):
  - Use branch names and commit messages that match the weekly pattern: `weekN-<short-desc>`.

If anything below is unclear or you want more details (for example, module-specific build quirks or DB connection examples), tell me which week/module to inspect and I will expand this file.
