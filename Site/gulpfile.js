const gulp = require('gulp');
const concat = require('gulp-concat');
const autoprefixer = require('gulp-autoprefixer');
const cleanCSS = require('gulp-clean-css');
const uglify = require('gulp-uglify');

function styles(){
 return gulp.src('./**/*.css')
          .pipe(concat('all.css'))
          .pipe(autoprefixer({
               browsers: ['> 0.1%'],
               cascade: false
           }))
           .pipe(cleanCSS({
               level: 2
           }))
          .pipe(gulp.dest('./build/css'));
}

function scripts(){
return gulp.src('./**/*.js')
          .pipe(concat('all.js'))
          //.pipe(uglify())
          .pipe(gulp.dest('./build/js'));

}


gulp.task('styles',styles);
gulp.task('scripts',scripts);