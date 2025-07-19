<div align="center">
  <div style="display: flex; align-items: center; justify-content: center; gap: 8px;">
    <img src="https://raw.githubusercontent.com/quarkiverse/.github/main/assets/images/quarkus.svg" alt="Quarkus logo" style="height: 70px; width: auto;">
    <img src="https://raw.githubusercontent.com/quarkiverse/.github/main/assets/images/plus-sign.svg" alt="Plus sign" style="height: 70px; width: auto;">
    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/195px-PDF_file_icon.svg.png" alt="iText/OpenPDF logo" style="height: 70px; width: auto;">
  </div>

  <h1>Quarkus iText/OpenPDF</h1>
</div>
<br>

[![Version](https://img.shields.io/maven-central/v/io.quarkiverse.itext/quarkus-itext?logo=apache-maven&style=flat-square)](https://search.maven.org/artifact/io.quarkiverse.itext/quarkus-itext)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square)](https://opensource.org/licenses/Apache-2.0)
[![Build](https://github.com/quarkiverse/quarkus-itext/actions/workflows/build.yml/badge.svg)](https://github.com/quarkiverse/quarkus-itext/actions/workflows/build.yml)

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-5-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->

## Overview

A Quarkus extension that lets you utilize [OpenPDF](https://github.com/LibrePDF/OpenPDF) or [iText](https://itextpdf.com/) or to create and manipulate PDFs on the fly.

> [!NOTE]
> The main purpose of this extension is to make iText/OpenPDF work in a native executable built with GraalVM/Mandrel.

> [!IMPORTANT]
> Consider using OpenPDF first, as it is modern and supports encrypted PDFs. Only resort to the legacy iText version if OpenPDF doesn't meet your needs.

## Getting started

Read the full [iText/OpenPDF documentation](https://docs.quarkiverse.io/quarkus-itext/dev/index.html).

### Prerequisite

* Create or use an existing Quarkus application
* Add the iText or OpenPDFextension with the [Quarkus CLI](https://quarkus.io/guides/cli-tooling):

**Recommended:**
```bash
quarkus ext add io.quarkiverse.openpdf:quarkus-openpdf
```
or 

**Legacy:**
```bash
quarkus ext add io.quarkiverse.itext:quarkus-itext
```

Or add to your pom.xml directly:

**Recommended:**
```xml
<dependency>
    <groupId>io.quarkiverse.openpdf</groupId>
    <artifactId>quarkus-openpdf</artifactId>
    <version>{project-version}</version>
</dependency>
```

**Legacy:**
```xml
<dependency>
    <groupId>io.quarkiverse.itext</groupId>
    <artifactId>quarkus-itext</artifactId>
    <version>{project-version}</version>
</dependency>
```

## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="http://melloware.com"><img src="https://avatars.githubusercontent.com/u/4399574?v=4?s=100" width="100px;" alt="Melloware"/><br /><sub><b>Melloware</b></sub></a><br /><a href="https://github.com/quarkiverse/quarkus-itext/commits?author=melloware" title="Code">💻</a> <a href="#maintenance-melloware" title="Maintenance">🚧</a></td>
      <td align="center" valign="top" width="14.28%"><a href="http://gastaldi.wordpress.com"><img src="https://avatars.githubusercontent.com/u/54133?v=4?s=100" width="100px;" alt="George Gastaldi"/><br /><sub><b>George Gastaldi</b></sub></a><br /><a href="#infra-gastaldi" title="Infrastructure (Hosting, Build-Tools, etc)">🚇</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/albfernandez"><img src="https://avatars.githubusercontent.com/u/2701620?v=4?s=100" width="100px;" alt="Alberto Fernández"/><br /><sub><b>Alberto Fernández</b></sub></a><br /><a href="https://github.com/quarkiverse/quarkus-itext/commits?author=albfernandez" title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/gattinaresh"><img src="https://avatars.githubusercontent.com/u/30138201?v=4?s=100" width="100px;" alt="gattinaresh"/><br /><sub><b>gattinaresh</b></sub></a><br /><a href="https://github.com/quarkiverse/quarkus-itext/commits?author=gattinaresh" title="Tests">⚠️</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/comrt"><img src="https://avatars.githubusercontent.com/u/8274510?v=4?s=100" width="100px;" alt="comrt"/><br /><sub><b>comrt</b></sub></a><br /><a href="#ideas-comrt" title="Ideas, Planning, & Feedback">🤔</a></td>
    </tr>
  </tbody>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!
