# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

A Maven-based Java Selenium WebDriver test automation project using TestNG. Tests drive a real Chrome browser (via `ChromeDriver`) against live URLs — there is no mocking layer.

## Commands

- Build: `mvn compile`
- Run all tests: `mvn test`
- Run a single test class: `mvn test -Dtest=LoginTest`
- Run a single test method: `mvn test -Dtest=LoginTest#loginSuccessfully`

Tests require a local Chrome installation and a matching `chromedriver` on PATH (Selenium Manager, bundled with `selenium-java` 4.x, resolves the driver automatically in most cases).

## Architecture

- `src/main/java/org/example/` — placeholder application code (`Main.java`), not part of the test suite.
- `src/test/java/tests/` — TestNG test classes. Each test class is currently self-contained: it instantiates its own `ChromeDriver`, defines its own `By` locators as fields, and quits the driver in an `@AfterMethod`. There is no shared base test class, page object layer, or driver factory yet — if adding new tests, follow the existing per-class pattern already in use rather than introducing a new abstraction unprompted.
- `LoginTest` reads credentials from the `CMS_USERNAME` and `CMS_PASSWORD` environment variables and fails fast via `Assert.assertNotNull` if they are missing. It targets a specific environment URL (`http://192.168.125.30:8080/#/`) — treat this as a test-environment dependency, not a public endpoint.
- Waits are a mix of explicit `WebDriverWait`/`ExpectedConditions` and hardcoded `Thread.sleep` calls; existing tests intentionally pause execution to make browser actions observable when run locally.
