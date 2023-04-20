#!/bin/sh

set -e

if [ -f tmp/pids/server.pid ]; then
  rm tmp/pids/server.pid
fi

bundle exec rake assets:precompile
bundle exec rake db:prepare
bundle exec rake db:seed
bundle exec rails s -b 0.0.0.0