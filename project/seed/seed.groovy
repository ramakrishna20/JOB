base_path = "project"
job_path = "${base_path}/seed"
folder("${base_path}")

pipelineJob(job_path) {
    description("This job will create a jenkins job to install kubernetes in azure vm ")
    logRotator {
        daysToKeep(30)
    }
    parameters {
        stringParam {
            name ('JOB_CREATION')
            defaultValue('')
            description('creating a job for kubernetes')
            trim(true)
        }
    }
    definition {
        cps {
            script(readFileFromWorkspace("${job_path}/scriptfile"))
            sandbox(false)
        }
    }
}
