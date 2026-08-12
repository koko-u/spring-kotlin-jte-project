project_root := justfile_directory()

_default:
    @just --list

# run application
run:
    {{ project_root }}/gradlew bootRun

# format code
fmt:
    ktlint --format \
           --editorconfig={{ project_root }}/.editorconfig \
           {{ project_root }}/src/**/*.kt

# docker up
[arg('profile', pattern='^(dev|test)$')]
dup profile='dev':
    #!/usr/bin/env bash
    set -euo pipefail

    docker compose -f {{ project_root }}/docker/compose.yml --profile {{ profile }} up -d

    if [[ "{{ profile }}" == "test" ]]; then
      until docker exec test_pg pg_isready -U $DATABASE_TEST_USER -d $DATABASE_TEST_NAME; do
        sleep 1
      done
      dbmate --url $DATABASE_TEST_URL up
    fi

# docker down
[arg('profile', pattern='^(dev|test)$')]
dwn profile='dev':
    docker compose -f {{ project_root }}/docker/compose.yml --profile {{ profile }} down
