lein_exe = "lein"

def run_command(command)
  system command
  exit_code = $?.exitstatus
  if exit_code != 0
    raise "Command failed with code #{exit_code}: #{command}"
  else
    puts "Command executed successfully: #{command}"
  end
end

def in_dir(path)
  pwd = Dir.getwd
  Dir.chdir path
  yield
ensure
  Dir.chdir pwd
end

DIRS = %w{gaeshi-dev gaeshi lein-gaeshi}

DIRS.each do |dir|

  namespace dir do
    desc "full #{dir} build"
    task :build do
      in_dir dir do
        run_command "#{lein_exe} deps"
        run_command "#{lein_exe} javac"
        run_command "#{lein_exe} spec"
        run_command "#{lein_exe} install"
      end
    end

    desc "push to clojars"
    task :push do
      in_dir dir do
        run_command "#{lein_exe} push"
      end
    end

    desc "install locally"
    task :install do
      in_dir dir do
        run_command "#{lein_exe} install"
      end
    end
  end

end

desc "build all projects"
task :build => DIRS.map {|dir| "#{dir}:build"}

desc "push all projects"
task :push => DIRS.map {|dir| "#{dir}:push"}

desc "install all projects"
task :install => DIRS.map {|dir| "#{dir}:install"}

task :default => :build
