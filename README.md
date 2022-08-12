
# omscs CLI Util

## Setup

1. Fork, clone the repo to your environment
1. Install project dependencies via `lein deps`
1. Install Chrome & Chrome WebDriver - see [Etaoin doc](https://cljdoc.org/d/etaoin/etaoin/1.0.38/doc/user-guide#install-webdrivers)

## Usage

1. Open course pages for OMSCS courses
  1. Update `/config.edn` with the courses you'd like to see e.g. `{... :courses ["CS 101"]}`
  1. `lein run -term <TERM>` e.g. `lein run -term Fall 2022`
