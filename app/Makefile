.DEFAULT_GOAL := build-run

clean:
	gradle clean

build:
	gradle clean build

install:
	gradle clean install

run-dist:
	./build/install/java-package/bin/java-package

run:
	gradle run

test:
	gradle test

report:
	gradle jacocoTestReport

lint:
	gradle checkstyleMain checkstyleTest

update-deps:
	gradle useLatestVersions


build-run: build run

.PHONY: build