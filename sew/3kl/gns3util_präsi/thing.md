---
title: gns3util
author: erm
---

Table of contents
---

<!-- alignment: center -->
- **About the project**
- **Design of the app**
- **Methodoligy and Inspirtion**
- **Basic features**
- **Educational Features**
- **Automation features**
- **Demo**
- **Q&A**

<!-- end_slide -->

About
---


* Cli util
* GNS3v3 api Wrapper
* fokus to use in the htl
* easy automation

<!-- end_slide -->

Why?
---

somehing something zivk etc etc

Goals
---
- good features to setup exercies in school as fast as possible
    - give stundest a better network emulation envirmnent
        - give teachers a better tooling to set it up
- bring dev ops quality of life to gns3


<!-- end_slide -->

App design
---
<!-- alignment: center -->
```
❯ gns3util --help
Usage: gns3util [OPTIONS] COMMAND [ARGS]...

  A utility for GNS3.

Options:
  -s, --server TEXT    GNS3 server URL  [required]
  -i, --insecure       Ignore unsigned SSL-Certificates
  -k, --key_file PATH  Set a location for a keyfile to use
  --help               Show this message and exit.

Commands:
  add                 Put commands.
  auth                Authentication commands.
  compute             Compute operations.
  controller          Controller operations.
  create              Creation commands.
  delete              Delete commands.
  fuzzy               Interactive get commands using fzf.
  get                 Get commands.
  image               Image operations.
  install             Install something in the GNS3 server
  install-completion  Install or uninstall shell completion for bash,...
  node                Node operations.
  post                Misc post commands.
  project             Project operations.
  script              script commands.
  snapshot            Snapshot operations.
  stream              Stream commands
  update              Put commands.
```

<!-- end_slide -->

Methodology und inspiration
---
Methodology
---
<!-- alignment: center -->
- Easy to automate
- good quality of life options
- don't hide options for more complex actions
    - but have an easy way to 80% of the needed actions
    - but expose enough for the last 20%
- use modern methods tools for the terminal like fuzzy finders

Inspiration
---
<!-- alignment: center -->
> Inspired by modern CLI-Tooling such as
- nvim telescope
- tmux sesionx
- k3sup
- docker context and kubectl

<!-- end_slide -->

Tooling
---

**1. Development & Build Tools**
<!-- alignment: center -->
*   **uv**
    *  Modern Python tooling to manage:
        *   virtual environments
        *   Python versions
        *   pip
        *   and more
*   **docker**
    *   To test the program isolated.
*   **make**
    * To automate common tasks:
        *   building and running the Docker image
        *   publishing the newest version of the package
*   **git** / **lazygit**
    *   Version control (`lazygit` for easier use of `git`).

<!-- alignment: left-->
**2. Deployment & Operations Tools**

<!-- alignment: center-->
*   **tailscale**
    *   Easy and fast remote access to the needed servers.


<!-- end_slide -->
Libaries
---
<!-- alignment: center -->

*   **click**
    *   Command Line Interface Creation Kit
*   **requests**
    *   Library for web requests and API calls
*   **rich**
    *   Outputting data with syntax highlighting
*   **bottle**
    *   Extremely lightweight web server framework
*   **InquirerPy**
    *   Collection of common interactive terminal actions
*   **paramiko**
    *   Implementation of SSHv2
*   **pyaml**
    *   YAML parsing library

<!-- end_slide -->
Code struktur
---

klassen und command groups

<!-- end_slide -->
Features
---
<!-- end_slide -->
Basic features
---
<!-- end_slide -->
Fuzzy features
---
<!-- end_slide -->
schul features
---
<!-- end_slide -->
script features
---
<!-- end_slide -->
install features
---
<!-- end_slide -->
roadmap
---
<!-- alignment: center -->
- add `k3sup` install and unistall of gns3 instaces
- like `kubectl` manage remote configs
- bring dev ops quality of life to gns3
- add integration and unit testing
<!-- end_slide -->
<!-- jump_to_middle -->

The end
---
