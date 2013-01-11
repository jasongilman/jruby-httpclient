# encoding: utf-8

require 'rubygems'
require 'bundler'
begin
  Bundler.setup(:default, :development)
rescue Bundler::BundlerError => e
  $stderr.puts e.message
  $stderr.puts "Run `bundle install` to install missing gems"
  exit e.status_code
end
require 'rake'
require 'rake/clean'

require 'jeweler'
Jeweler::Tasks.new do |gem|
  # gem is a Gem::Specification... see http://docs.rubygems.org/read/chapter/20 for more options
  gem.name = "jruby-httpclient"
  gem.homepage = "http://github.com/aesterline/jruby-httpclient"
  gem.license = "Apache 2.0"
  gem.summary = %Q{A thin wrapper around the Apache HttpClient}
  gem.description = %Q{An HTTP client designed for use with JRuby in a threaded environment}
  gem.email = "adam@esterlines.com"
  gem.authors = ["Adam Esterline"]
  gem.platform = Gem::Platform::JAVA
  # dependencies defined in Gemfile
  gem.files = [
    ".document",
    ".rvmrc",
    "Gemfile",
    "Gemfile.lock",
    "LICENSE.txt",
    "README.rdoc",
    "Rakefile",
    "VERSION",
    "jruby-httpclient.gemspec",
    "lib/http_client.rb",
    "lib/http_client/jruby/client.rb",
    "lib/http_client/jruby/client_configuration.rb",
    "lib/http_client/jruby/methods.rb",
    "lib/http_client/jruby/response.rb",
    "lib/http_client/mri/client.rb",
    "lib/http_client/mri/methods.rb",
    "lib/http_client/mri/response.rb",
    "lib/http_client/status.rb",
    "test/helper.rb",
    "test/http_client/jruby/test_client_configuration.rb",
    "test/http_client/test_basic_auth.rb",
    "test/http_client/test_basic_client_operations.rb",
    "test/http_client/test_client_headers.rb",
    "test/http_client/test_cookies.rb",
    "test/http_client/test_redirect.rb",
    "test/http_client/test_request_body.rb",
    "test/http_client/test_response.rb",
    "test/http_client/test_server_headers.rb",
    "test/http_test_server.rb",
    "vendor/commons-codec-1.4.jar",
    "vendor/commons-logging-1.1.1.jar",
    "vendor/httpclient-4.1.1.jar",
    "vendor/httpclient-cache-4.1.1.jar",
    "vendor/httpcore-4.1.jar",
    "vendor/httpmime-4.1.1.jar",
    "vendor/extras.jar"
  ]
end
Jeweler::RubygemsDotOrgTasks.new

require 'rake/testtask'
Rake::TestTask.new(:test) do |test|
  test.libs << 'lib' << 'test'
  test.pattern = 'test/**/test_*.rb'
  test.verbose = true
end

task :default => :test

require 'rdoc/task'
RDoc::Task.new do |rdoc|
  version = File.exist?('VERSION') ? File.read('VERSION') : ""

  rdoc.rdoc_dir = 'rdoc'
  rdoc.title = "http_client #{version}"
  rdoc.rdoc_files.include('README*')
  rdoc.rdoc_files.include('lib/**/*.rb')
end


CLOBBER.add("bin")
directory "bin"

# Compiles code in src/extras into a extras.jar file.
# At the time of writing this contains only a single class that allows deletes to contain a body
task :build_extras => ["bin"] do
  classpath = Dir["vendor/*.jar"]
  command = "javac -classpath #{classpath.join(":")} -d bin src/extras/EntityEnclosingDelete.java"
  puts "Executing: #{command}"
  `#{command}`

  command = "jar cf vendor/extras.jar -C bin ."
  puts "Executing: #{command}"
  `#{command}`
  puts "vendor/extras.jar created"
end
